import { NativeModules } from 'react-native';
import { isEmpty, isIOS } from "my-rn-base-utils";
export class RNYoutubeVideoMoudule {
    static openFullScreenYotubeVideo(videoId) {
        if (isIOS()) {
            console.log("Not support IOS");
            return;
        }
        NativeModules.RNYoutubeVideoMoudule.openFullScreenYotubeVideo(videoId);
    }
    /**
     * size: small, big (default)
     * */
    static getYoutubeThumb(videoId, size) {
        if (videoId.startsWith("http")) {
            let regExp = /^.*(youtu\.be\/|v\/|u\/\w\/|embed\/|watch\?v=|\&v=)([^#\&\?]*).*/;
            let match = videoId.match(regExp);
            if (match && match[2].length === 11) {
                videoId = match[2];
            }
            else {
                console.log("======== ERROR: can not get videoId from: ", videoId);
            }
        }
        if (videoId === null) {
            return "http://img.youtube.com/vi/noimagefound/default.jpg";
        }
        size = (size == undefined) ? 'big' : size;
        if (size === 'small') {
            return "http://img.youtube.com/vi/" + videoId + "/default.jpg";
        }
        return 'http://img.youtube.com/vi/' + videoId + '/0.jpg';
    }
    static getYoutubeId(youtubeUrl) {
        if (isEmpty(youtubeUrl))
            return undefined;
        if (youtubeUrl.startsWith("http") || youtubeUrl.startsWith("//") || youtubeUrl.startsWith(":/")) {
            let regExp = /^.*(youtu\.be\/|v\/|u\/\w\/|embed\/|watch\?v=|\&v=)([^#\&\?]*).*/;
            let match = youtubeUrl.match(regExp);
            if (match && match[2].length === 11) {
                return match[2];
            }
            else
                return undefined;
        }
        return youtubeUrl;
    }
}
