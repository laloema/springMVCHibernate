/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.HibernateUtil;
import Model.TeamsModel;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ADMON
 */
public class TeamsController {
    @RequestMapping(value = "get_all_teams.htm", method = RequestMethod.GET)
    public ModelAndView get_data(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView("get_all_teams");
        
        String error = "-1";
        //String estado_cuenta = request.getParameter("estado_cuenta");
        
        
        
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        try {
            
            String procedure = "SELECT * FROM sp_allteams()";
            String procedure2 = "SELECT * FROM sp_allteams()";
            System.out.println(procedure);
            
            Query query = session.createSQLQuery(procedure);
            Query query2 = session.createSQLQuery(procedure2).setResultTransformer(Transformers.aliasToBean(TeamsModel.class));
            
            List<Object[]> result = query.list();
            List<TeamsModel> result2 = query2.list();
            
            mv.addObject("datos", result);
            mv.addObject("datos2", result2);

            session.getTransaction().commit();
            session.close();

        } catch (HibernateException e) {
            mv.addObject("error", error);
            session.getTransaction().rollback();
        }

        return mv;
    }
}
