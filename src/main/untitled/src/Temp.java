import javax.swing.text.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Temp {
    public static void main(String[] args) {


    public List expList() throws FISException
    {
        Utilities utilities = new Utilities();

        PreparedStatement sqlQueryStmt = null;
        ResultSet resultSet = null;
        int index = 1;
        List expList = new ArrayList();
        Connection conn = null;
        Logger logger = Logger.getInstance();
        try
        {
            String resource = null;
            String sql = "SELECT factory_node_id,exp_id FROM s_exp where dept = ?";
            sqlQueryStmt = conn.prepareStatement(sql);
            sqlQueryStmt.setString(index++,dept);
            resultSet = sqlQueryStmt.executeQuery();
            while(resultSet.next())
            {
                expNo= resultSet.getString(2);
                expList.add(expNo);
            }
        }
        catch(Exception e)
        {
            logger.error(Logger.FLOW,"Error in getting expNo",e);
        }
        finally
        {
            DBUtils.cleanUp(sqlQueryStmt,resultSet);
            DBUtils.cleanUp(conn);
        }
        return expList;
    }

    <%
    List expList = new ArrayList();
    expList =factory.getList("resource_list_data");
    request.setAttribute("expNos ", expList );
    %>


    <c:forEach var="item" items="${expNos}">
    <input type="checkbox"  value="${item}"/>
    </c:forEach>
}
