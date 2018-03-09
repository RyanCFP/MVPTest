package com.example.ryan.mvptest;

import org.junit.Test;

import java.util.IllegalFormatException;
import java.util.Locale;

/**
 * Created by ryan on 17-10-10.
 * Email pls refer to:ryan_chan0217@yeah.net
 */

public class UriTest {
    @Test
    public void TestUriFormat() throws Exception{

    }

    public enum Scheme{
        HTTP("http"),
        HTTPS("https"),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");

        private String scheme;
        private String UriPrefix;

       Scheme(String scheme){
            this.scheme = scheme;
            this.UriPrefix = scheme + "://";
        }

        public static Scheme ofUri(String uri){
            if(uri != null){
                for(Scheme s:values()){
                 if(s.belongsTo(uri)) return s;
                }
            }
            return UNKNOWN;
        }

        public boolean belongsTo(String uri){
            return uri.toLowerCase(Locale.US).startsWith(this.UriPrefix);
        }

        public String toUri(String path){
            return  this.UriPrefix + path;
        }

        public String cropTo(String uri){
            if(!belongsTo(uri)) {
                throw new IllegalArgumentException(String.format("arguments [%1$s] and format [%2$s]",uri,UriPrefix));
            }
            return uri.substring(UriPrefix);
        }

        public String cropScheme(String uri){

        }
    }
}
