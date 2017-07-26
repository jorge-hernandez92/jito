<div style="padding-left: 150px; padding-right: 150px;">
	<div class="panel panel-default">
		<div class="panel-body">
			<form class="form-horizontal">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Peso
						total (Kg):</label>
					<div class="col-md-6">
						<input type="text" class="form-control" id="inputEmail3"
							placeholder="Peso total">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Precio
						total:</label>
					<div class="col-md-6 ">
						<input type="text" class="form-control" id="inputEmail3"
							placeholder="Precio total">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Fecha:</label>
					<div class="col-md-6 ">
						<div class='input-group date' id='dateHarvest'>
							<input type='text' class="form-control" ng-model="selectedDt" data-date-time-picker /> 
							<span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Comentarios:</label>
					<div class="col-md-6">
						<textarea class="form-control" rows="3"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Agregar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>