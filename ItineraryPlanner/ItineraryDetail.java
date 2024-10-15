package ItineraryPlanner;

public class ItineraryDetail {
    private String itineraryID;
    private String activityName;
    private String startTime;
    private String endTime;
    private double activityCost;

    public ItineraryDetail(String itineraryID, String activityName, String startTime, String endTime,
            double activityCost) {
        this.itineraryID = itineraryID;
        this.activityName = activityName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityCost = activityCost;
    }

    // Getters and setters

    public String getItineraryID() {
        return itineraryID;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public double getActivityCost() {
        return activityCost;
    }

    public void setItineraryID(String itineraryID) {
        this.itineraryID = itineraryID;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setActivityCost(double activityCost) {
        this.activityCost = activityCost;
    }
}
