<div style="padding-left: 130px; padding-right: 130px;">
	<div class="panel panel-default">
		<div class="panel-body">
			<form class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-2 control-label">Peso total (Kg):</label>
					<div class="col-md-6">
						<input type="number" lang="en-150" ng-model="harvest.peso" class="form-control"
							placeholder="Peso total">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Precio total ($):</label>
					<div class="col-md-6 ">
						<input type="number" ng-model="harvest.precio" class="form-control"
							placeholder="Precio total">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Fecha de corte:</label>
					<div class="col-md-8 ">
						<md-datepicker ng-model="harvest.date" md-placeholder="Fecha de corte"></md-datepicker>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Comentarios:</label>
					<div class="col-md-6">
						<textarea class="form-control" ng-model="harvest.comments" rows="3"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<label ng-if="harvest.peso > 0 && harvest.precio > 0"  class="control-label">Precio por Kilo: {{ harvest.precio / harvest.peso | currency}} Pesos</label>

					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-default" ng-click="save(harvest)" value="Guardar" />
						<input type="button" class="btn btn-default" ng-click="resetHarvest()" value="Limpiar" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>