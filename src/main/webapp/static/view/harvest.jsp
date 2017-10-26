<div style="padding-left: 50px; padding-right: 50px;" ng-controller="HarvestController as ctrl">
	<div class="panel panel-default">
		<div class="panel-body">		
			<form class="form-horizontal was-validated"" name="harvestForm" ng-submit="save(harvest)">
			
				<div class="form-group row">
					<label class="col-sm-3 control-label">Peso total (Kg):</label>
					<div class="col-md-7">
						<input type="number" step="any" name="weight" ng-model="harvest.weight" class="form-control" placeholder="Peso total" required>
						<div class="invalid-feedback">Agrega el peso (Kg) del Producto. Solo Números</div>
						<div class="valid-feedback">
							<label  ng-show="harvest.weight != null" class="control-label">{{ harvest.weight | number}} Kg </label>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-3 control-label">Precio total ($):</label>
					<div class="col-md-7">
						<input type="number" step="any" name="price" ng-model="harvest.price" class="form-control" placeholder="Precio total" required>
						<div class="invalid-feedback">Agrega el precio del Producto. Solo Números</div>
						<div class="valid-feedback">
							<label  ng-show="harvest.weight != null" class="control-label">{{ harvest.price | currency}} Pesos</label>
						</div>	
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-3 control-label" >Fecha de corte:</label>
					<div class="col-md-7">
						<md-datepicker name="date" ng-model="harvest.date" md-placeholder="Fecha de corte" required></md-datepicker>
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
						<input type="button" class="btn btn-outline-secondary" ng-click="resetHarvest()" value="Limpiar" />
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
					<td>{{ harvest.price | currency}} Pesos</td>
					<td>{{ harvest.price / harvest.weight | currency}} Pesos</td>
					<td>{{ harvest.formatDate}}</td>
					<td>
						<button type="button" class="btn btn-outline-success" ng-click="editHarvest(harvest)"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
						<button type="button" class="btn btn-outline-danger"  ng-click="deleteHarvest(harvest)"><i class="fa fa-trash-o" aria-hidden="true"></i></button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>