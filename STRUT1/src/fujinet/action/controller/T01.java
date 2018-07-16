package fujinet.action.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;

import org.apache.struts.action.ActionForward;

import org.apache.struts.action.ActionMapping;

import fujinet.action.model.bean.*;

public class T01 extends org.apache.struts.action.Action {

/* forward name=”success” path=”” */

private final static String SUCCESS ="success";

private final static String FAILED ="failed";

/**

* This is the action called from the Struts framework.

* @param mapping The ActionMapping used to select this instance.

* @param form The optional ActionForm bean for this request.

* @param request The HTTP Request we are processing.

* @param response The HTTP Response we are processing.

* @throws java.lang.Exception

* @return

*/

@Override

public ActionForward execute(ActionMapping mapping, ActionForm  form,

HttpServletRequest request, HttpServletResponse response)

throws Exception {

customer_info frm=(customer_info)form;

if(frm.getName().trim().equals(""))

return mapping.findForward(FAILED);

return mapping.findForward(SUCCESS);

}



}
