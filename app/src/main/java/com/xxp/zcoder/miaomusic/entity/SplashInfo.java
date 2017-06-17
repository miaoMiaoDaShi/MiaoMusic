package com.xxp.zcoder.miaomusic.entity;

import java.util.List;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class SplashInfo {
    //http://cn.bing.com/az/hprichbg/rb/WolfeCreekCrater_ZH-CN10953577427_720x1280.jpg
    /**
     * images : [{"startdate":"20170613","fullstartdate":"201706131600","enddate":"20170614","url":"/az/hprichbg/rb/WolfeCreekCrater_ZH-CN10953577427_1920x1080.jpg","urlbase":"/az/hprichbg/rb/WolfeCreekCrater_ZH-CN10953577427","copyright":"西澳大利亚霍尔斯克里克附近的陨石撞击坑 (© Randy Olson/National Geographic Creative/Getty Images)","copyrightlink":"http://www.bing.com/search?q=%E9%99%A8%E7%9F%B3%E5%9D%91&form=hpcapt&mkt=zh-cn","quiz":"/search?q=Bing+homepage+quiz&filters=WQOskey:%22HPQuiz_20170613_WolfeCreekCrater%22&FORM=HPQUIZ","wp":true,"hsh":"133561ddef7542ee034a56f644d2df0d","drk":1,"top":1,"bot":1,"hs":[]}]
     * tooltips : {"loading":"正在加载...","previous":"上一个图像","next":"下一个图像","walle":"此图片不能下载用作壁纸。","walls":"下载今日美图。仅限用作桌面壁纸。"}
     */

    private List<ImagesBean> images;


    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class TooltipsBean {
    }

    public static class ImagesBean {
        /**
         * startdate : 20170613
         * fullstartdate : 201706131600
         * enddate : 20170614
         * url : /az/hprichbg/rb/WolfeCreekCrater_ZH-CN10953577427_1920x1080.jpg
         * urlbase : /az/hprichbg/rb/WolfeCreekCrater_ZH-CN10953577427
         * copyright : 西澳大利亚霍尔斯克里克附近的陨石撞击坑 (© Randy Olson/National Geographic Creative/Getty Images)
         * copyrightlink : http://www.bing.com/search?q=%E9%99%A8%E7%9F%B3%E5%9D%91&form=hpcapt&mkt=zh-cn
         * quiz : /search?q=Bing+homepage+quiz&filters=WQOskey:%22HPQuiz_20170613_WolfeCreekCrater%22&FORM=HPQUIZ
         * wp : true
         * hsh : 133561ddef7542ee034a56f644d2df0d
         * drk : 1
         * top : 1
         * bot : 1
         * hs : []
         */

        private String url;
        private String urlbase;
        private String copyright;
        private String hsh;

        public String getUrl() {
            return url;
        }

        public String getUrlbase() {
            return urlbase;
        }

        public void setUrlbase(String urlbase) {
            this.urlbase = urlbase;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getHsh() {
            return hsh;
        }

        public void setHsh(String hsh) {
            this.hsh = hsh;
        }
    }

    @Override
    public String toString() {
        return "SplashInfo{" +
                "images=" + images +
                '}';
    }
}
