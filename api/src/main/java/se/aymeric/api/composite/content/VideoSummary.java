package se.aymeric.api.composite.content;

public class VideoSummary {

    private final int videoId;
    private final String title;
    private final int duration; // Duration in seconds

    public VideoSummary(int videoId, String title, int duration) {
        this.videoId = videoId;
        this.title = title;
        this.duration = duration;
    }

    public int getVideoId() {
        return videoId;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
