export declare class RNYoutubeVideoMoudule {
    static openFullScreenYotubeVideo(videoId: string, YOUTUBE_KEY: string): void;
    /**
     * size: small, big (default)
     * */
    static getYoutubeThumb(videoId: string, size: "small" | "big"): string;
    static getYoutubeId(youtubeUrl: string): string;
}
