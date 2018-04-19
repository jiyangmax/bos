package cn.jiyang.bos.web.action.base;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.jiyang.bos.domain.base.Standard;
import cn.jiyang.bos.service.base.StandardService;

@Namespace("/")
@ParentPackage("json-default")
@Controller
@Scope("prototype")
public class StandardAction extends ActionSupport implements ModelDriven<Standard>{
	
	private Standard standard = new Standard();
	
	@Override
	public Standard getModel() {
		// TODO Auto-generated method stub
		return standard;
	}
	private int page;
	private int rows;
	
	
	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	@Autowired
	private StandardService standardService;
	
	@Action(value = "standard_save", results = { @Result(name = "success", type = "redirect", location = "./pages/base/standard.html") })
	public String save(){
		standardService.save(standard);
		return "success";
	}
	
	@Action(value="standard_pageQuery",results={@Result(name="success",type="json")})
	public String pageQuery(){
		Pageable pageable=new PageRequest(page-1,rows);
		
		Page<Standard> pageData=standardService.pageQuery(pageable);
		ActionContext.getContext().getValueStack().push(pageData);
		
		return SUCCESS;
	}
}
