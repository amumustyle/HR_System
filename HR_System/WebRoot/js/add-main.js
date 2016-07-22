// function setLayout() {
//     var height = document.documentElement.clientHeight || document.body.clientHeight;
//     var width = document.documentElement.clientWidth || document.body.clientWidth;
//     document.getElementById('mainWrap').style.height = height - 70 + 'px';
//     document.getElementById('aside').style.height = height - 70 + 'px';
//     document.getElementById('tableDetail').style.width = width - 240 + 'px';
// }
// setLayout();
tableStyle();
function tableStyle() {
    $('tr:odd').addClass('odd');
    $('tr:even').addClass('even');
}
$(document).bind('click', function(event) {
    if(event.target.id == 'del-add') {
        // $('#class-detail').hide();
        $('#fr-add').hide();
        return false;
    }
    if(event.target.id == 'add-class') {
        // $('#class-detail').show();
        $('#fr-add').show();
        return false;
    }
    if(event.target.id == 'mod') {
        // $('#class-mod').show();
		$('#fr-mod').show();
        return false;
    }
    if(event.target.id == 'del-mod') {
        // $('#class-mod').hide();
		$('#fr-mod').hide();
        return false;
    }
    if(event.target.className == "del") {
        confirm("确认删除?");
    }
}).bind('mouseover', function(event) {
    if(event.target.id == 'btn-add') {
    }
});