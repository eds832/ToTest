public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Path cd(String newPath) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
 String[] newP=newPath.split("/");
     String[] oldP=path.split("/");
     int lnCount=0;
     for(String str:newP){
      if(str.equals("..")){
       lnCount++;
      }
     }
     
     int len=oldP.length;
     String strOut="";
     for(int i=0;i<len-lnCount;i++){
      strOut=strOut+oldP[i]+"/";
     }
     
     len=newP.length;
     for(int i=0;i<len;i++){
      if(!newP[i].equals("..")){
       strOut=strOut+newP[i]+"/";
      }
     }
     path=strOut.substring(0, strOut.length()-1);
        //System.out.println(path);
     if(path.indexOf("/")<0)
      throw new UnsupportedOperationException("Directory not found");
     return this;
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath());
    }
}
