<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <body>
        <form:form method="POST" commandName="goods">
            <table>
                <tr>
                    <td>Наименование:</td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td>Количество:</td>
                    <td><form:input path="quantity" /></td>
                    
                </tr>
                <tr>
                    <td><button type="submit">Купить</button></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>