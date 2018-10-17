<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href=".">
    <title>大轮毂汽车视频</title>
    <link rel="shortcut icon" href="http://www.dalungu.com/imgs/ico.ico">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/category.css">
    <script src="./dalungu_files/hm.js"></script>
</head>

<body>
<header class="header">
    <div class="header_left">
        xxx
    </div>
</header>
<div class="body">
    <nav class="nav">
        <a class="logo-link" href="http://www.dalungu.com/">
            <#--<img class="logo" src="/images/logo.png" width="150">-->
        </a>
        <ul class="navList">
            <li><a class="nav-active">首页</a></li>

            <li><a href="/news/">今日更新</a></li>

            <li><a href="/tuijian/">推荐</a></li>

        </ul>
    </nav>
    <div class="content">
        <div class="content-left" style="height: 1814px;">
            <ul class="content-list">
                <div class="authorlist mt12">
                    <#list mainLst as item>
                        <dl>
                            <a href="/thread?sid=${item.id}" style="display: block;" target="_blank">
                                <dt>
                                <img src="${item.coverImgUrl}" alt="" >
                                <p style="overflow-wrap: break-word;">${item.title}</p>
                                </dt>
                            </a>
                        </dl>
                    </#list>
                </div>
            </ul>
        </div>
        <div class="content-right">
            <#--<div class="searchBox">-->
                <#--<form name="searchform" id="searchform" method="get">-->
                    <#--<input name="key" id="key" class="searchInput" type="text" placeholder="搜索......" value="">-->
                    <#--<button class="searchButton" onclick="search()">搜索</button>-->
                <#--</form>-->
            <#--</div>-->

            <div class="hot">
                <h3>热门</h3>
                <ul class="hot-video">
                    <#list hotLst as item>
                        <li>
                            <a href="http://www.dalungu.com/page/SsdQamFw" target="_blank">
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
            <#--<div class="hot">-->
                <#--<h3>今日推荐</h3>-->
                <#--<ul class="new-list">-->

                    <#--<li>-->
                        <#--<a href="http://www.dalungu.com/page/SsdQamFw" target="_blank">-->
                            <#--<div class="hot-video-img">-->
                                <#--<img src="./dalungu_files/054101015BB35DACAD8C70C4C6604866" alt="" width="100%" height="100%">-->
                            <#--</div>-->
                            <#--<div class="hot-video-title">-->
                                <#--<h4>2018巴黎车展：广汽传祺全新GS5正式发布</h4>-->
                                <#--<p>29次播放<span>·</span>几次评论</p>-->
                            <#--</div>-->
                        <#--</a>-->
                    <#--</li>-->
                <#--</ul>-->
            <#--</div>-->
            <div class="copyright">
                <ul>
                    <li>© 2018 MSF www.msf.zone</li>
                    <li>部分图片来自网络，如有侵权，联系我们删除！</li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>