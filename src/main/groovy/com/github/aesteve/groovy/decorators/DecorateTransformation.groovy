package com.github.aesteve.groovy.decorators

import com.github.aesteve.groovy.decorators.annot.Decorate
import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.AnnotationNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.ast.stmt.Statement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@CompileStatic
@TypeChecked
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class DecorateTransformation implements ASTTransformation {

	@Override
	void visit(ASTNode[] nodes, SourceUnit source) {
		if (!checkNode(nodes, Decorate)) return
		AnnotationNode annotationNode = nodes[0] as AnnotationNode
		ConstantExpression expr = annotationNode.members.values()[0] as ConstantExpression
		String annot = expr.value
		MethodNode methodNode = nodes[1] as MethodNode
		Statement methodStmt = methodNode.code
		// is it possible to have a kind of decorators registry ? a static map maybe ?
	}

	private boolean checkNode(ASTNode[] astNodes, annotationType) {
		if (!astNodes) return false
		if (!astNodes[0]) return false
		if (astNodes.size() < 2) return false
		if (!astNodes[1]) return false
		if (!(astNodes[0] instanceof AnnotationNode)) return false
		if (!((AnnotationNode)astNodes[0]).classNode?.name == annotationType) return false
		if (!(astNodes[1] instanceof MethodNode)) return false
		true
	}

}
