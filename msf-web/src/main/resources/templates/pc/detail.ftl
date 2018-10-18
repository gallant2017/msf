<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href=".">
    <title>${objTopic.title} - 美少妇</title>
    <link rel="icon" href="/images/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/index.css">
    <script src="http://code.jquery.com/jquery-1.4.1.min.js"></script>
</head>

<body>
<header class="header">
    <div class="header_left">
        美少妇-海量好图任你看 www.msf.zone
    </div>
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
        if (!IsPC()) {
            window.location.href = 'http://m.msf.zone';
        }
    </script>
</header>
<div class="body">
    <nav class="nav">
        <a class="logo-link" href="http://www.msf.zone/">
            <img class="logo" src="/images/logo.png" width="150">
        </a>
        <ul class="navList">
            <li><a href="/">首页</a></li>

            <li><a href="/news/">今日更新</a></li>

            <li><a href="/tuijian/">推荐</a></li>

            <li><a href="/wangqi/">往期</a></li>
        </ul>
    </nav>
    <div class="content">
        <div class="content-left" style="height: 1814px;">
            <p class="title">${objTopic.title}<p>
            <div class="date">${objTopic.createdOn?datetime('yyyy-MM-dd HH:mm')}</div>
        <#list lstImg as item>
            <div class="imgBox">
                <img class="img lazy" lazysrc="${item.url}"
                     src="/images/x.png"
                     alt="${item.memo1}"></div>
        </#list>
        </div>
        <div class="content-right">
            <div class="hot">
                <h3>热门</h3>
                <ul class="hot-video">
                <#list hotLst as item>
                    <li>
                        <a href="/thread?_sid=${item.id?c}"  target="_blank">
                            <div class="hot-video-img">
                                <img src="${item.coverImgUrl}" alt="">
                            </div>
                            <div class="hot-video-title">
                                <h4>${item.title}</h4>
                                <p>${item.view_count}次浏览</p>
                            </div>
                        </a>
                    </li>
                </#list>
                </ul>
            </div>
            <div class="copyright">
                <ul>
                    <li>© 2018 MSF www.msf.zone</li>
                    <li>部分图片来自网络，如有侵权，联系我们删除！</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<script src="${staticUrl}js/z.js?v=${jsVersion}"></script>
</body>
</html>