$(document).on('pagebeforeshow', '#etatimprimanteon', function(){ 
    $('<input>').appendTo('[ data-role="content"]').attr({'name':'slider','id':'slider','data-highlight':'true','min':'0','max':'100','value':'50','type':'range'}).slider({
        create: function( event, ui ) {
            $(this).parent().find('input').hide();
            $(this).parent().find('input').css('margin-left','-9999px'); // Fix for some FF versions
            $(this).parent().find('.ui-slider-track').css('margin','0 15px 0 15px');
            $(this).parent().find('.ui-slider-handle').hide();
        }
    }).slider("refresh");      
    
    // Test
    var i = 1;
    var interval = setInterval(function(){
        progressBar.setValue('#slider',i);
        if(i === 100) {
            clearInterval(interval);
        }
        i++;
    },100);    
});

var progressBar = {
    setValue:function(id, value) {
        $(id).val(value);
        $(id).slider("refresh");
    }
}