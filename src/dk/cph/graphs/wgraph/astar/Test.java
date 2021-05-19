package dk.cph.graphs.wgraph.astar;


import dk.cph.graphs.wgraph.astar.interfaces.AStarProblem;
import dk.cph.graphs.wgraph.astar.interfaces.ManhattanFactory;
import dk.cph.graphs.wgraph.astar.interfaces.ManhattanGraph;
import dk.cph.graphs.wgraph.builder.Graph;

import java.io.IOException;

public class Test
{
	public static void main(String[] args) throws IOException {
		ManhattanFactory manhattanFactory = new ManhattanFactoryImpl();

		astarSolver(manhattanFactory, "doc/astar/Tiny.txt");

		//astarSolver(manhattanFactory, "doc/astar/ProblemA.txt");

		//astarSolver(manhattanFactory, "doc/astar/ProblemA.txt");

	}

	private static void astarSolver(ManhattanFactory manhattanFactory, String s) throws IOException {
		ManhattanGraph tiny = manhattanFactory.readFromFile(s);
		AStarProblem problem = new ManhattanProblem(tiny);
		Graph g = problem.getGraph();

		System.out.println(g + "\n _______________________________________________________________________________________ \n Astar");

		Astar astar = new Astar(problem);
		String out = astar.toString();
		System.out.println(out);
	}
}
