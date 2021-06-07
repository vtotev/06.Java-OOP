package WorkingWithAbstraction.TrafficLights;

public class TrafficLight {
    private LIGHT_STATE state;

    public LIGHT_STATE getState() {
        return state;
    }

    public TrafficLight(LIGHT_STATE initialState) {
        this.state = initialState;
    }

    public void update() {
        switch (state) {
            case RED:
                state = LIGHT_STATE.GREEN;
                break;

            case GREEN:
                state = LIGHT_STATE.YELLOW;
                break;

            case YELLOW:
                state = LIGHT_STATE.RED;
                break;
        }
    }
}
