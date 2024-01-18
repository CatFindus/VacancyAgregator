let vacancies;
let vacancyRequest;
let currentPage=0;
let pageCount;
var e = document.getElementById("id_count");
let selected;
function setCookie(cname, cvalue, exdays)
{
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length,c.length);
    }
    return "";
}
function doSearch() {
    let habrSearch = $('#s1-14').is(":checked");
    let hhSearch = $('#s2-14').is(":checked");
    let liSearch = $('#s3-14').is(":checked");
    let rrSearch = $('#s4-14').is(":checked");
    let searchRequest = $('#searchRequest').val();
    vacancyRequest = JSON.stringify({searchRequest:searchRequest, habrSearch:habrSearch, hhSearch:hhSearch, liSearch:liSearch, rrSearch:rrSearch});
    setCookie("vacReq", vacancyRequest, 1);
    window.location.replace("/pages/searchresult.html");
}
function getVacancies() {
    vacancyRequest=getCookie("vacReq");
    if(vacancies===undefined) {
        $('.section_search_class').append("<img id='loading_img' class='deletable_element' src='../resources/loading.gif' alt='loading'/>")
        alert(vacancyRequest);
        $.ajax({
            url: "/search",
            type: "POST",
            data: vacancyRequest,
            success: function (data) {
                vacancies = data;
                goToPage(0);
            },
            contentType: "application/json",
            dataType: 'json'
        });
    }
}
function getTestVacancies() {
    if (vacancies===undefined) {
        $('.section_search_class').append("<img id='loading_img' class='deletable_element' src='../resources/loading.gif' alt='loading'/>");
        $.ajax({
            url: "/search",
            type: "GET",
            data: vacancyRequest,
            success: function (data) {
                vacancies = data;
                goToPage(0);
            },
            contentType: "application/json",
            dataType: 'json'
        });
    }
}
function redrawTable() {
    $(".deletable_element").remove();
    $(".deletable_td").remove();
    $(".deletable_tr").remove();
    let endCount;
    endCount=(currentPage+1)*selected;
    if(endCount>vacancies.length) endCount=vacancies.length;
    for (let i = currentPage*selected; i < endCount; i++) {
        let num = i+1;
        $("#tbody").append("<tr class=\"deletable_tr\">" +
            "<td class=\"deletable_td tdNum\">"+num+"</td>" +
            "<td class=\"deletable_td tdSite\">"+vacancies[i].siteName+"</td>" +
            "<td class=\"deletable_td tdTitle\">"+"<a class=\"deletable_element\" href=\""+vacancies[i].url+"\">"+vacancies[i].title+"</a>"+"</td>" +
            "<td class=\"deletable_td tdSalary\">"+vacancies[i].salary+"</td>" +
            "<td class=\"deletable_td tdCompany\">"+vacancies[i].companyName+"</td>" +
            "<td class=\"deletable_td tdCity\">"+vacancies[i].city+"</td>" + "</tr>");
    }
}
function goToPage(pageNumber) {
    currentPage=pageNumber;
    selected = e.options[e.selectedIndex].text;
    pageCount = Math.ceil(vacancies.length/selected);
    redrawTable();
    panelDraw();
}
function panelDraw() {
    let str='';
    let pageMin=currentPage-7;
    let pageMax=currentPage+8;
    if (pageMin<0) pageMin=0;
    if (pageMax>pageCount) pageMax=pageCount;
    for (let i = pageMin+1; i <= pageMax; i++) {
        let fun = "'goToPage("+ (i-1) +")'";
        if(i===(currentPage+1)) {
            $('#page_count').append("<button class='button-28 deletable_element' disabled>" + i.toString() + "</button>");
        } else {
            $('#page_count').append("<button class='button-28 deletable_element' onclick=" + fun +">" + i.toString() + "</button>");
        }
    }
}