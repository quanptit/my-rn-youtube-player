export declare class RNYoutubeVideoMoudule {
    static openFullScreenYotubeVideo(videoId: string): void;
    /**
     * size: small, big (default)
     * */
    static getYoutubeThumb(videoId: string, size: "small" | "big"): string;
    static getYoutubeId(youtubeUrl: string): string;
}
