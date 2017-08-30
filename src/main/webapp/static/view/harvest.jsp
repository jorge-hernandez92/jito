<div style="padding-left: 50px; padding-right: 50px;">
	<div class="panel panel-default">
		<div class="panel-body">		
			<form class="form-horizontal" name="harvestForm" ng-submit="save(harvest)">
			
				<div class="form-group row " ng-class="{ 'has-error' : harvestForm.weight.$invalid && !harvestForm.weight.$pristine, 'has-success': harvestForm.weight.$valid}">
					<label class="col-sm-3 control-label">Peso total (Kg):</label>
					<div class="col-md-7">
						<input type="number"  name="weight" ng-model="harvest.weight" class="form-control" placeholder="Peso total" required>
							<p ng-show="harvestForm.weight.$invalid  && !harvestForm.weight.$pristine" class="help-block">El peso (kg) del corte es requerido</p>
					</div>
				</div>
				<div class="form-group row" ng-class="{ 'has-error' : harvestForm.price.$invalid && !harvestForm.price.$pristine, 'has-success': harvestForm.price.$valid}">
					<label class="col-sm-3 control-label">Precio total ($):</label>
					<div class="col-md-7">
						<input type="number" name="price" ng-model="harvest.price" class="form-control" placeholder="Precio total" required>
						<p ng-show="harvestForm.price.$invalid  && !harvestForm.price.$pristine" class="help-block">El precio ($) del corte es requerido</p>	
					</div>
				</div>
				<div class="form-group row"  ng-class="{ 'has-error' : harvestForm.date.$invalid && !harvestForm.date.$pristine, 'has-success': harvestForm.date.$valid}">
					<label class="col-sm-3 control-label" >Fecha de corte:</label>
					<div class="col-md-7">
						<md-datepicker name="date" ng-model="harvest.date" md-placeholder="Fecha de corte" required></md-datepicker>
						<p ng-show="harvestForm.date.$invalid  && !harvestForm.date.$pristine" class="help-block">La fecha de corte es requerida</p>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-3 control-label">Comentarios:</label>
					<div class="col-md-7">
						<textarea class="form-control" ng-model="harvest.comments" rows="3"></textarea>
					</div>
				</div>
				<div class="form-group row" style="text-align: center;">
					<div class="col-sm-offset-3 col-sm-10">
						<label  ng-show="harvest.price != null && harvest.weight != null" class="control-label">Precio por Kilo: {{ harvest.price / harvest.weight | currency}} Pesos</label>
						<label  ng-show="harvest.price == null || harvest.weight == null" class="control-label">Precio por Kilo: $0.00 Pesos</label>
					</div>
				</div> 
				<div class="form-group row" style="text-align: center;">
					<div class="col-sm-offset-3 col-sm-10">
						<button type="submit" class="btn btn-outline-primary" ng-disabled="harvestForm.$invalid">Guardar</button>
						<input type="button" class="btn btn-outline-secondary"" ng-click="resetHarvest()" value="Limpiar" />
					</div>
				</div>				
			</form>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-body">
			<table class="table table-striped">
				<tr>
					<th>Peso total</th>
					<th>Precio total</th>
					<th>Precio Kilo</th>
					<th>Fecha de Corte</th>
					<th>Opciones</th>
				</tr>
				<tr ng-repeat="harvest in listHarvest">
					<td>{{ harvest.weight | number }} kg</td>
					<td>{{ harvest.totalPrice | currency}} Pesos</td>
					<td>{{ harvest.totalPrice / harvest.weight | currency}} Pesos</td>
					<td>{{ harvest.harvestCutDate}}</td>
					<td>
<!-- 						<button type="button" class="btn btn-primary"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button> -->
<!-- 						<button type="button" class="btn btn-danger"><i class="fa fa-trash-o" aria-hidden="true"></i></button> -->
						<button type="button" class="btn btn-outline-success"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
						<button type="button" class="btn btn-outline-danger"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>