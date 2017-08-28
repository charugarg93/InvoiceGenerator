/* Reference taken from : http://outbottle.com/spring-3-mvc-adding-objects-to-a-list-element-on-the-fly-at-form-submit-generic-method/*/
function DynamicListHelper( config ) {
    
    init();
    
    var lastRow;
    
    function init() {
        config.rowClass = makeClass(config.rowClass);
        config.addRowId = makeId(config.addRowId);
        config.removeRowClass = makeClass(config.removeRowClass);
        config.formId = makeId(config.formId);
        config.rowContainerId = makeId(config.rowContainerId);
        //config.indexedPropertyName = 
        //config.indexedPropertyMemberNames =
        //config.rowAddedListener = 
        //config.rowRemovedListener = 
        //config.beforeSubmit = 
        addRemoveRowListener();
        addAddRowListener();
        prepRows();
        $(config.formId).submit( function() {
            prepFormForSubmit();
            if( config.beforeSubmit != null ) {
                return config.beforeSubmit();
            } else {
                return true;
            }
        });
        dealWithPotentialDefaultRow();
    }
    
    function dealWithPotentialDefaultRow() {
        var defaultRow = $(config.formId).find(config.rowClass+".defaultRow:last");
        $(defaultRow).removeClass('defaultRow');
        lastRow = defaultRow.clone(true);
        $(defaultRow).remove();
    }
    
    function prepFormForSubmit() {
        var memberArray = config.indexedPropertyMemberNames.split(',');
        for( var i in memberArray ) {
            var className = '.DynamicListHelper_' + $.trim(memberArray[i]);
            var index = 0;
            $(className).each( function(){
                $(this).attr('name',config.indexedPropertyName + "["+index+"]." + $.trim(memberArray[i]));
                index++;
            });
        }
    }
    
    function prepRows() {
        var memberArray = config.indexedPropertyMemberNames.split(',');
        for( var i in memberArray ) {
            var s = config.indexedPropertyName + "[";
            var e = "]." + $.trim(memberArray[i]);
            $(config.rowContainerId).find('*').each( function(){
                if( $(this).attr('name') ) {
                    var bs = ($(this).attr('name').indexOf(s) === 0);
                    var be = ($(this).attr('name').match( e+"$" ) != null);
                    if( bs && be ) {
                        $(this).addClass('DynamicListHelper_'+ $.trim(memberArray[i]));
                    }
                }
            });
        }
    }
    
    function removeRow(element) {
        lastRow = $(config.formId).find(config.rowClass+":last").clone(true);
        $(element).closest(config.rowClass).remove();
        prepFormForSubmit();
        if( config.rowRemovedListener != null ) {
            config.rowRemovedListener(element);
        }
    }
    
    function addRow() {
        var row = $(config.formId).find(config.rowClass+":last").clone(true);
        if( !row.length )
            row  = lastRow;
        if(typeof $(row).attr('id') !== 'undefined') {
            $(row).attr('id', $(row).attr('id')+'_1' );
        }
        $(row).find('*').each(function(){
            if(typeof $(this).attr('id') !== 'undefined') {
                $(this).attr('id', $(this).attr('id')+'_1');
            }
        });
        $(config.rowContainerId).append(row);
        prepFormForSubmit();
        if( config.rowAddedListener != null ) {
            config.rowAddedListener($(row));
        }
    }
    
    function addRemoveRowListener() {
        $(config.removeRowClass).click( function(){
           removeRow($(this).closest(config.rowClass)); 
           return false;
        });
    }
    function addAddRowListener() {
        $(config.addRowId).click( function(){
            addRow();
            return false;
        });
    }
    
    function makeClass(className) {
        if( className.indexOf('.') != 0 )
            className = "."+className;
        return className;
    }
    function makeId(className) {
        if( className.indexOf('#') != 0 )
            className = "#"+className;
        return className;
    }

}

