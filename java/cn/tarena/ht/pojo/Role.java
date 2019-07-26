package cn.tarena.ht.pojo;

public class Role extends BaseEntity{

	private String RoleId;
	private String name;
	private String remarks;
	private Integer orderNo;
	private String id;
	private String pId;
	//是回显用户已拥有的角色
	//checked属性是zTree树的固定写法
	private Boolean checked;
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "Role [RoleId=" + RoleId + ", name=" + name + ", remarks=" + remarks + ", orderNo=" + orderNo + ", id="
				+ id + ", pId=" + pId + ", checked=" + checked + "]";
	}
}
