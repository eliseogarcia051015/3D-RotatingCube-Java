public class Cube {

    public Vector[] vertices = {
        //Z=1
        new Vector(-1, 1, 1),
        new Vector(1, 1, 1),
        new Vector(-1, -1, 1),
        new Vector(1, -1, 1),

        //Z=-1
        new Vector(-1, 1, -1),
        new Vector(1, 1, -1),
        new Vector(1, -1, -1),
        new Vector(-1, -1, -1)
    };

    //undirected graph
    public int[][] edges = {
        {0,1}, {0,2}, {0,4}, //node0 connected vertices 1,2,4
        {1,3}, {1, 5},
        {2, 3}, {2, 6},
        {3,7},
        {4,5}, {4,6},
        {5,6},
        {6,7}
    };
}
