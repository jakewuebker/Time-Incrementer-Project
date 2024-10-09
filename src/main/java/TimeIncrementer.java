public final class TimeIncrementer {
    private int seconds;
    private int minutes;
    private int hours;

    // Constructor with parameters and validation
    public TimeIncrementer(int hours, int minutes, int seconds) {
        if (hours < 0 || hours >= 24) {
            throw new IllegalArgumentException("Hours must be between 0 and 23");
        }
        if (minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("Minutes must be between 0 and 59");
        }
        if (seconds < 0 || seconds >= 60) {
            throw new IllegalArgumentException("Seconds must be between 0 and 59");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Constructor without parameters
    public TimeIncrementer(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    // Getter for seconds
    public int getSeconds(){
        return this.seconds;
    }

    // Getter for minutes
    public int getMinutes(){
        return this.minutes;
    }

    // Getter for hours
    public int getHours(){
        return this.hours;
    }

    // Setter for seconds with validation
    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds >= 60) {
            throw new IllegalArgumentException("Seconds must be between 0 and 59");
        }
        this.seconds = seconds;
    }

    // Setter for minutes with validation
    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("Minutes must be between 0 and 59");
        }
        this.minutes = minutes;
    }

    // Setter for hours with validation
    public void setHours(int hours) {
        if (hours < 0 || hours >= 24) {
            throw new IllegalArgumentException("Hours must be between 0 and 23");
        }
        this.hours = hours;
    }

    // Method to increment seconds
    public void incrementSeconds(int seconds) {
        this.seconds += seconds;
        if (this.seconds >= 60) {
            incrementMinutes(this.seconds / 60);
            this.seconds = this.seconds % 60;
        }
    }

    // Method to increment minutes
    public void incrementMinutes(int minutes) {
        this.minutes += minutes;
        if (this.minutes >= 60) {
            incrementHours(this.minutes / 60);
            this.minutes = this.minutes % 60;
        }
    }

    // Method to increment hours
    public void incrementHours(int hours) {
        this.hours += hours;
        if (this.hours >= 24) {
            this.hours = this.hours % 24;
        }
    }

    // Method to display time in standard format
    public String displayStandardTime() {
        String period = (this.hours >= 12) ? "PM" : "AM";
        int displayHours = (this.hours > 12) ? this.hours - 12 : this.hours;
        displayHours = (displayHours == 0) ? 12 : displayHours; // Handle midnight and noon
        return String.format("%02d:%02d:%02d %s", displayHours, this.minutes, this.seconds, period);
    }

    // Method to display time in military format
    public String displayMilitaryTime() {
        return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }
}