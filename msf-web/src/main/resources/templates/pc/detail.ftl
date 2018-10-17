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
</header>
<div class="body">
    <nav class="nav">
        <a class="logo-link" href="http://www.msf.zone/">
            <img class="logo" src="/images/logo.png" width="150">
        </a>
        <ul class="navList">
            <li><a class="nav-active">首页</a></li>

            <li><a href="/">今日更新</a></li>

            <li><a href="/">推荐</a></li>

        </ul>
    </nav>
    <div class="content">
        <div class="content-left" style="height: 1814px;">
            <p class="title">${objTopic.title}<p>
            <div style="font-size:0.6em;float: left;color: #ccc;margin-top: 1em;">${objTopic.createdOn?datetime('yyyy-MM-dd HH:mm')}</div>
        <#list lstImg as item>
            <div class="imgBox" style="margin-top: 60px;">
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
                        <a href="/" target="_blank">
                            <div class="hot-video-img">
                                <img src="${item.coverImgUrl}" alt="" width="100%" height="100%">
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