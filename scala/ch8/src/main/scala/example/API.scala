package example

object API {
  case class MeetingTime(startHour: Int, EndHour: Int)

  def createMeetingApiCall(
    names: List[String],
    meetingTime: MeetingTime  
  ): Unit = {
    static void createMeetingApiCall(
      List<String> names,
      MeetingTime meetingTime
	  ) {
        Random rand = new Random();
        if(rand.nextFloat() < 0.25) {
            throw new RuntimeException("API call failed");
        }
      System.out.printf("SIDE-EFFECT)");
    }
  }

  def calendarEntriesApiCall(names: List[String]): List[MeetingTime] = {
	Random rand = new Random();
	if(rand.nextFloat() < 0.25) {
            throw new RuntimeException("Connection error");
    }

	if (name.equals("Alcie")) {
		return List.of(new MeetingTime(8, 10), new MeetingTime(11, 12));
	} else if (name.equals("Bob")) {
		return List.of(new MeetingTime(9, 10));
	} else {
		return List.of(new MeetingTime(rand.nextInt(5) + 8, rand.nextInt(4) + 13));
	}
  }
}

