public class InfoFilter {
    private final Integer  trafficLimit;
    private Integer actualTraffic;



    public InfoFilter(Integer trafficLimit, Integer actualTraffic) {
        this.trafficLimit = trafficLimit;
        this.actualTraffic = actualTraffic;
    }

    public Integer getTrafficLimit() {
        return trafficLimit;
    }

    public Integer getActualTraffic() {
        return actualTraffic;
    }

    public void setActualTraffic(Integer actualTraffic) {
        this.actualTraffic = actualTraffic;
    }

    public boolean isBlocked() {
        return actualTraffic >= IpFilter.BLOCK_LIMIT;
    }
}
