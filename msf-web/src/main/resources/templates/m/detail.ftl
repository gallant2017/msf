<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <title>${objTopic.title}</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <meta name="keywords" content="美少妇，msf，msf.zone,少妇">
    <link rel="icon" href="/images/favicon.ico" type="image/x-icon" />
    <script>
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

<div class="feed clearfix">
    <p class="title">${objTopic.title}<p>
    <div style="font-size:0.6em;float: right;color: #ccc;margin: 1em;">${objTopic.createdOn?datetime('yyyy-MM-dd HH:mm')}</div>
<#list lstImg as item>
    <a href="#">
        <div class="item">
            <div class="imgBox">
                <img class="img lazy" lazysrc="${item.url}"
                     src="/images/x.png"
                     alt="${item.memo1}"></div>
            <#--<div class="content">-->
                <#--&lt;#&ndash;<p class="title">${item.memo1}</p>&ndash;&gt;-->
                <#--&lt;#&ndash;<div class="pub"><span></span> </div>&ndash;&gt;-->
                <#--&lt;#&ndash;<div class="like"><i></i><span>100</span></div>&ndash;&gt;-->
            <#--</div>-->
        </div>
    </a>
</#list>
</div>

<#--<div class='footer'>-->
    <#--<a href="/">-->
        <#--<div class='tab'>-->
            <#--<div class="home active"></div>-->
            <#--<p class="active">首页</p></div>-->
    <#--</a>-->
    <#--<a href="/category">-->
        <#--<div class='tab'>-->
            <#--<div class="dis"></div>-->
            <#--<p>品味</p></div>-->
    <#--</a>-->
<#--</div>-->
<#--<a href="/" class="go-home">返回首页</a>-->
<a href="/" class="go-home">返回首页</a>
<script src="${staticUrl}js/common.js?v=${jsVersion}"></script>
<script src="${staticUrl}js/z.js?v=${jsVersion}"></script>
</body>

</html>