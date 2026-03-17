public class Cube {

    public Vector[] vertices = {
        //Z=1
        new Vector(-1, 1, 1),     //0
        new Vector(1, 1, 1),    //1
        new Vector(-1, -1, 1),       //2
        new Vector(1, -1, 1),     //3

        //Z=-1
        new Vector(-1, 1, -1),      //4
        new Vector(1, 1, -1),     //5
        new Vector(1, -1, -1),      //6
        new Vector(-1, -1, -1)         //7
    };

    //undirected graph
    public int[][] edges = {
        {0,1},{1,3},{3,2},{2,0},    //front face edges
        {4,5},{5,6},{6,7},{7,4},    //back
        {0,4},{1,5},{2,7},{3,6}     //sides
    }; 
}
