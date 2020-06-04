/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Model.HibernateUtil;
import Model.TeamsModel;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 *
 * @author ADMON
 */
public class RepositoryTeams {
    Session session = HibernateUtil.getSessionFactory().openSession();
    
    public List<TeamsModel> getAllTemas(){
        session.beginTransaction();
        String procedure2 = "SELECT * FROM sp_allteams()";
        Query query2 = session.createSQLQuery(procedure2).setResultTransformer(Transformers.aliasToBean(TeamsModel.class));
        List<TeamsModel> result2 = query2.list();
        return result2;
    }
}
