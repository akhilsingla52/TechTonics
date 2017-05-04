package com.atmecs.pojo;

public class Event{
	private int event_id;
	private String name;
	private String type;
	private String description;
	private String start_date;
	private String end_date;
	private String duration;
	private String presenter;
	
	public Event()
	{
		this(0,"","","","","","","");
	}

	public Event(int event_id, String name, String type, String description, String start_date, String end_date,
			String duration, String presenter)
	{
		super();
		this.event_id = event_id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.duration = duration;
		this.presenter = presenter;
	}

	public int getEvent_id()
	{
		return event_id;
	}

	public void setEvent_id(int event_id)
	{
		this.event_id = event_id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getStart_date()
	{
		return start_date;
	}

	public void setStart_date(String start_date)
	{
		this.start_date = start_date;
	}

	public String getEnd_date()
	{
		return end_date;
	}

	public void setEnd_date(String end_date)
	{
		this.end_date = end_date;
	}

	public String getDuration()
	{
		return duration;
	}

	public void setDuration(String duration)
	{
		this.duration = duration;
	}

	public String getPresenter()
	{
		return presenter;
	}

	public void setPresenter(String presenter)
	{
		this.presenter = presenter;
	}

	@Override
	public String toString()
	{
		return "Event [event_id=" + event_id + ", name=" + name + ", type=" + type + ", description=" + description
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", duration=" + duration + ", presenter="
				+ presenter + "]";
	}
	
}
