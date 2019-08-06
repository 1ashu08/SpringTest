import sailpoint.object.Schema;
import sailpoint.connector.Connector;
import sailpoint.connector.DelimitedFileConnector;
// Importing the classes which allow us to create permissions
import sailpoint.object.Permission;

if ( schema.getObjectType().compareTo(Connector.TYPE_ACCOUNT) == 0) {
   HashMap map = DelimitedFileConnector.defaultBuildMap(cols, record);
   return map;
} else if ( schema.getObjectType().compareTo(Connector.TYPE_GROUP) == 0) {
   // Calling the Connector to retrieve account attributes as an Hash Map
   HashMap map = DelimitedFileConnector.defaultBuildMap(cols, record);
   String permission = (String)map.get("Permission Rights");
   
   // Here we are using our permission model... Such as: right, write, execute, update on target. 
   if ( permission != null && permission.contains("-")) {
      // We create an Arraylist bucket to populate all permission objects
      List perms = new ArrayList();
      String [] permissions = permission.split("-");
      for ( int i = 0; permissions.length > i; i ++ ) {
          String target = permissions[i].substring(0, permissions[i].indexOf(":"));
          String permission = permissions[i].substring(permissions[i].indexOf(":"));      
          if ( permission.equals(":YY") ) {
             // For each Permission we have to create a new object. Therefore the multiple new object declaration
             Permission perm = new Permission();
             perm.setRights("update");
             perm.setTarget(target);
             perms.add(perm);
             Permission perm = new Permission();
             perm.setRights("create");
             perm.setTarget(target);
             perms.add(perm);
          } else { 
             Permission perm = new Permission();
             perm.setRights("execute");
             perm.setTarget(target);
             perms.add(perm); 
          }
      }
     // We finished building our permissions and return the ArrayList object which represents a multi valued attribute of permissions
     map.put("directPermissions", perms);
   }
   return map;
}
