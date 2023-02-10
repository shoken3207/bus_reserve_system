package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import consts.Definition;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/*")
public class Filter extends HttpFilter implements javax.servlet.Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String target = ((HttpServletRequest)request).getRequestURI();

		boolean isIgnore = false;
		for (String url: Definition.ignoreURL) {
			if (target.contains(url)) isIgnore = true;
		}

		if (!isIgnore) {
			HttpSession session = ((HttpServletRequest) request).getSession();
			if (session.getAttribute("user") == null) {
				((HttpServletResponse) response).sendRedirect("login");
				return;
			}
		}
		chain.doFilter(request, response);
		// pass the request along the filter chain
	}

}
