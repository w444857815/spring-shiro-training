package com.wangzhixuan.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangzhixuan.model.Organization;
import com.wangzhixuan.service.OrganizationService;
import com.wangzhixuan.vo.Tree;

@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(OrganizationController.class);

	@Autowired
	private OrganizationService organizationService;

	@RequestMapping("/manager")
	public String manager() {
		return "/admin/organization";
	}

	@RequestMapping(value = "/tree", method = RequestMethod.POST)
	@ResponseBody
	public List<Tree> tree() {
	    List<Tree> trees = organizationService.findTree();
		return trees;
	}
	
	@RequestMapping("/treeGrid")
    @ResponseBody
    public List<Organization> treeGrid() {
	    List<Organization> treeGrid =organizationService.findTreeGrid();
        return treeGrid;
    }


/*	@RequestMapping("/addPage")
	public String addPage() {
		return "/admin/organizationAdd";
	}

	@RequestMapping("/add")
	@ResponseBody
	public Json add(Organization organization) {
		Json j = new Json();
		try {
			organizationService.add(organization);
			j.setSuccess(true);
			j.setMsg("添加成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/get")
	@ResponseBody
	public Organization get(Long id) {
		return organizationService.get(id);
	}

	@RequestMapping("/editPage")
	public String editPage(HttpServletRequest request, Long id) {
		Organization o = organizationService.get(id);
		request.setAttribute("organization", o);
		return "/admin/organizationEdit";
	}

	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(Organization org) throws InterruptedException {
		Json j = new Json();
		try {
			organizationService.edit(org);
			j.setSuccess(true);
			j.setMsg("编辑成功！");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Json delete(Long id) {
		Json j = new Json();
		try {
			organizationService.delete(id);
			j.setMsg("删除成功！");
			j.setSuccess(true);
		} catch (ServiceException e) {
			j.setMsg(e.getMessage());
		}
		return j;
	}*/
}
