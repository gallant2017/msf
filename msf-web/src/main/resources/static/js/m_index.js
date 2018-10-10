({
    init: function () {
        var me = this;
        me.p = 1;
        me.s = 5;
        me.isLoading = false;
        me.hasMore = true;
        me.event();
    },
    event: function () {
        var me = this;
        me.getList();
    },
    getList: function () { //圈子sns列表
        var me = this;

        $.ajax({
            type: "get",
            url: "/api/feed/list",
            data: {
                p: me.p,
                s: me.s
            },
            async: true,
            beforeSend:function () {
                me.isLoading = true;
                $(".loading").show()
            },
            success: function (data) {
                if (data.code == 0) {
                    me.bindData(data.obj);
                } else {
                    me.hasMore = false;
                }
            },
            complete: function () {
                me.isLoading = false;

            }
        });
    },
    bindData: function (lst) {
        var me = this;
        if (lst.length>0) {
            var lsthtml="";
            $.each(lst, function (i, item) {
                lsthtml += "<a href=\"/thread?_sid=" + item.id + "\">";
                lsthtml += "<div class=\"item\">";

                lsthtml += "<div class=\"imgBox\">";
                lsthtml += "<img class=\"img lazy\" src=\"" + item.coverImgUrl + "\" alt=\"" + item.title + "\">";
                lsthtml += "</div>";

                lsthtml += "<div class=\"content\">";
                lsthtml += "<p class=\"title\">" + item.title + "</p>";
                lsthtml += "<div class=\"pub\"><span>" + item.createdOn + "</span></div>"
                lsthtml += "</div>";

                lsthtml += "</div>";
                lsthtml += "</a>"
            });
            $(".feed").append(lsthtml);
            $(".loading").hide();
        }
        if (lst.length < me.s) {
            me.hasMore = false;
        }
        if (me.p == 1) {
            $(window).scroll(function () {
                var totalheight = parseFloat($(window).height()) + parseFloat($(window).scrollTop());
                if (($(document).height() - 30) <= totalheight) {
                    if (me.hasMore && !me.isLoading) {
                        me.getList();
                    }
                }
            });
        }
        $(".loading").hide();
        me.p++;
    }
}).init();