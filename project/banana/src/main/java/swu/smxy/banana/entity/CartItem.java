package swu.smxy.banana.entity;

public class CartItem implements BaseEntity {
	
	private String itemId;
    private String itemName;
    private Integer itemCount;
    private String businessId;
	
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
    /**
     * @return String return the itemId
     */
    public String getItemId()
    {
        return itemId;
    }

    /**
     * @param itemId
     *                   the itemId to set
     */
    public void setItemId(String itemId)
    {
        this.itemId = itemId;
    }

    /**
     * @return String return the itemName
     */
    public String getItemName()
    {
        return itemName;
    }

    /**
     * @param itemName
     *                     the itemName to set
     */
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    /**
     * @return Integer return the itemCount
     */
    public Integer getItemCount()
    {
        return itemCount;
    }

    /**
     * @param itemCount
     *                      the itemCount to set
     */
    public void setItemCount(Integer itemCount)
    {
        this.itemCount = itemCount;
    }

    /**
     * @return String return the businessId
     */
    public String getBusinessId()
    {
        return businessId;
    }

    /**
     * @param businessId
     *                       the businessId to set
     */
    public void setBusinessId(String businessId)
    {
        this.businessId = businessId;
    }
}
