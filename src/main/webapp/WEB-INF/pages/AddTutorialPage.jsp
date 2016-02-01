<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<jsp:include page="layout/Header.jsp"></jsp:include>
<div class="row">
	<div class="col-md-7 col-md-offset-2">

		<form class="form form-horizontal"
			action="/PersonalTutorialsRepo/add-tutorial" method="POST">

			<div class="form-group">
				<label>category</label> <input type="text" name="category"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>title</label> <input type="text" name="title"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>author</label> <input type="text" name="author"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>url</label><input type="text" name="url" class="form-control" />
			</div>
			<div class="form-group">
				<label>serviceDomain</label> <input type="text" name="serviceDomain"
					class="form-control" />
			</div>
			<div class="form-group">
				<label>rating</label> <input type="number" name="rating"
					class="form-control" />
			</div>
			<div class="form-group">
				reworkedInPercents<input type="number" name="reworkedInPercents"
					class="form-control" />
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-success" />
			</div>

		</form>

	</div>
</div>

<jsp:include page="layout/Footer.jsp"></jsp:include>