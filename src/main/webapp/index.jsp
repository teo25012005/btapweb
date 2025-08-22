<!-- src/main/webapp/index.jsp -->
<form action="emailList" method="post">
    <input type="hidden" name="action" value="add">

    <label>Email:</label>
    <input type="email" name="email" required><br>

    <label>First Name:</label>
    <input type="text" name="firstName" required><br>

    <label>Last Name:</label>
    <input type="text" name="lastName" required><br>

    <label>&nbsp;</label>
    <input type="submit" value="Join Now" id="submit">
</form>
