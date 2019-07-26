package cn.tarena.ht.pojo;

//数据库中的字段 ---对应着成员变量
//需要继承抽象类，完成共同的字段
public class Dept extends BaseEntity{
	//成员变量:dept_p表独有的字段
	private String deptId;//主键不能冲突
	private String parentId;//该部门的上级部门
	private String deptName;//部门名称
	private Integer state;//部门状态 ：0停用 1启用
	
	public void setState(Integer state) {
		this.state = state;
	}
	//自关联的关系
	private Dept parentDept;//上级部门的信息

	public Dept getParentDept() {
		return parentDept;
	}
	public void setParentDept(Dept parentDept) {
		this.parentDept = parentDept;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getState() {
		return state;
	}


}
