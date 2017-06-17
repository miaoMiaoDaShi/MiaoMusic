package com.xxp.zcoder.miaomusic.http;

import com.xxp.zcoder.miaomusic.entity.ArtistInfo;
import com.xxp.zcoder.miaomusic.entity.DownloadInfo;
import com.xxp.zcoder.miaomusic.entity.LrcInfo;
import com.xxp.zcoder.miaomusic.entity.MusicListInfo;
import com.xxp.zcoder.miaomusic.entity.SearchMusic;
import com.xxp.zcoder.miaomusic.entity.SplashInfo;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;

/**
 * Created by Zcoder
 * Email : 1340751953@qq.com
 * Time :  2017/6/14
 * Description :
 */

public class HttpClient {
    public static final String SPLASH_URL = "http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1";
    private static final String BASE_URL = "http://tingapi.ting.baidu.com/v1/restserver/ting";
    private static final String METHOD_GET_MUSIC_LIST = "baidu.ting.billboard.billList";
    private static final String METHOD_DOWNLOAD_MUSIC = "baidu.ting.song.play";
    private static final String METHOD_ARTIST_INFO = "baidu.ting.artist.getInfo";
    private static final String METHOD_SEARCH_MUSIC = "baidu.ting.search.catalogSug";
    private static final String METHOD_LRC = "baidu.ting.song.lry";
    private static final String PARAM_METHOD = "method";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_SIZE = "size";
    private static final String PARAM_OFFSET = "offset";
    private static final String PARAM_SONG_ID = "songid";
    private static final String PARAM_TING_UID = "tinguid";
    private static final String PARAM_QUERY = "query";


    /**
     * 加载每日的启动图的json信息
     *
     * @param splashUrl
     * @param httpCallBack
     */
    public static void loadSplashJson(String splashUrl, final HttpCallback<SplashInfo> httpCallBack) {
        OkHttpUtils.get().url(splashUrl).build().execute(new JsonCallback<SplashInfo>(SplashInfo.class) {
            @Override
            public void onError(Call call, Exception e, int i) {
                httpCallBack.onError(e);
            }

            @Override
            public void onResponse(SplashInfo splashInfo, int i) {
                httpCallBack.onSuccess(splashInfo);
            }

            @Override
            public void onAfter(int id) {
                httpCallBack.onDone();
            }
        });
    }

    /**
     * 下载文件使用
     *
     * @param url
     * @param destFileDir
     * @param destFileName
     * @param callback
     */
    public static void downloadFile(String url, String destFileDir, String destFileName, final HttpCallback<File> callback) {
        OkHttpUtils.get().url(url).build()
                .execute(new FileCallBack(destFileDir, destFileName) {
                    @Override
                    public void inProgress(float progress, long total, int id) {
                    }

                    @Override
                    public void onResponse(File file, int id) {
                        callback.onSuccess(file);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onDone();
                    }
                });
    }

    //获取歌曲列表集合信息(榜单)
    public static void getSongListInfo(String type, int size, int offset, final HttpCallback<MusicListInfo> callback) {
        OkHttpUtils.get().url(BASE_URL)
                .addParams(PARAM_METHOD, METHOD_GET_MUSIC_LIST)
                .addParams(PARAM_TYPE, type)
                .addParams(PARAM_SIZE, String.valueOf(size))
                .addParams(PARAM_OFFSET, String.valueOf(offset))
                .build()
                .execute(new JsonCallback<MusicListInfo>(MusicListInfo.class) {
                    @Override
                    public void onResponse(MusicListInfo response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onDone();
                    }
                });
    }

    /**
     * 获取歌曲的下载信息
     *
     * @param songId
     * @param callback
     */
    public static void getMusicDownloadInfo(String songId, final HttpCallback<DownloadInfo> callback) {
        OkHttpUtils.get().url(BASE_URL)
                .addParams(PARAM_METHOD, METHOD_DOWNLOAD_MUSIC)
                .addParams(PARAM_SONG_ID, songId)
                .build()
                .execute(new JsonCallback<DownloadInfo>(DownloadInfo.class) {
                    @Override
                    public void onResponse(DownloadInfo response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onDone();
                    }
                });
    }

    /**
     * 获得歌词
     *
     * @param songId
     * @param callback
     */
    public static void getLrc(String songId, final HttpCallback<LrcInfo> callback) {
        OkHttpUtils.get().url(BASE_URL)
                .addParams(PARAM_METHOD, METHOD_LRC)
                .addParams(PARAM_SONG_ID, songId)
                .build()
                .execute(new JsonCallback<LrcInfo>(LrcInfo.class) {
                    @Override
                    public void onResponse(LrcInfo response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onDone();
                    }
                });
    }

    /**
     * 得到歌手的相关的信息
     * @param tingUid
     * @param callback
     */
    public static void getArtistInfo(String tingUid, final HttpCallback<ArtistInfo> callback) {
        OkHttpUtils.get().url(BASE_URL)
                .addParams(PARAM_METHOD, METHOD_ARTIST_INFO)
                .addParams(PARAM_TING_UID, tingUid)
                .build()
                .execute(new JsonCallback<ArtistInfo>(ArtistInfo.class) {
                    @Override
                    public void onResponse(ArtistInfo response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onDone();
                    }
                });
    }

    /**
     * 搜索音乐(从网络)
     *
     * @param keyword
     * @param callback
     */
    public static void searchMusic(String keyword, final HttpCallback<SearchMusic> callback) {
        OkHttpUtils.get().url(BASE_URL)
                .addParams(PARAM_METHOD, METHOD_SEARCH_MUSIC)
                .addParams(PARAM_QUERY, keyword)
                .build()
                .execute(new JsonCallback<SearchMusic>(SearchMusic.class) {
                    @Override
                    public void onResponse(SearchMusic response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onError(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onDone();
                    }
                });
    }


}
