package org.toru0707.action;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.toru0707.form.AddForm;
import org.toru0707.service.EntriesService;

public class AddAction {

    public String result;
    
    
    @Resource
    protected EntriesService entriesService;

    @ActionForm
    @Resource
    protected AddForm addForm;

    @Execute(validator = false)
    public String index() {
        return "index.jsp";
    }

    @Execute(input = "index.jsp")
    public String submit() {
    	result = entriesService.getEntryById("a").title;
        //result = Integer.valueOf(addForm.arg1) + Integer.valueOf(addForm.arg2);
        return "index.jsp";
    }
}