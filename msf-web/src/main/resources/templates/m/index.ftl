<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>美少妇 - 好图尽在美少妇msf.zone - ${categoryName!}</title>
    <meta name="keywords" content="美少妇,图片写真,美少妇,msf.zone,好图尽在美少妇,少妇,${categoryName!}">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta name="keywords" content="美少妇，msf，msf.zone,少妇">
    <link rel="icon" href="/images/favicon.ico" type="image/x-icon"/>
    <script>
        //是否为pc
        function IsPC() {
            var userAgentInfo = navigator.userAgent;
            var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");
            var flag = true;
            for (var v = 0; v < Agents.length; v++) {
                if (userAgentInfo.indexOf(Agents[v]) > 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
        if (IsPC()) {
            window.location.href = 'http://www.msf.zone';
        }
    </script>
    <script src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
    <link href="/css/m_reset.css" rel="stylesheet" type="text/css"/>
    <link href="/css/m_index.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<#include "common/header.ftl">
<div class="feed clearfix"></div>
<div>
    <img class="loading" style="display: none" src="/images/loading.gif">
</div>
<div class='footer'>
    <a href="/">
        <div class='tab'>
            <div class="home active"></div>
            <p class="active">首页</p></div>
    </a>
    <a href="/category">
        <div class='tab'>
            <div class="dis"></div>
            <p>品味</p></div>
    </a>
<#--<a href="/novel">-->
<#--<div class='tab'>-->
<#--<div class="novel"></div>-->
<#--<p>段子</p></div>-->
<#--</a>-->
<#--<a href="/collecting">-->
<#--<div class='tab'>-->
<#--<div class="app"></div>-->
<#--<p>收藏</p></div>-->
<#--</a>-->
</div>
<script>
    var categoryId =${categoryId};
</script>
<script src="${staticUrl}js/m_index.js?v=${jsVersion}"></script>
<script src="${staticUrl}js/common.js?v=${jsVersion}"></script>
</body>
</html>