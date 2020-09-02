package swu.smxy.banana.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Cart implements BaseEntity {

	private String id;
	private String userId;
	private String itemId;
	private String itemName;
	private Long itemNum;
	private Float itemPrice;

	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserId()
	{
		return userId;
	}
	
	public String getItemId() 
	{
		return itemId;
	}
	
	public Long getItemNum() 
	{
		
	}

	
}
