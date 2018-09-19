var defaultElectric = null;
var defaultWater = null;
var defaultEmail = null;
if (!String.prototype.format) {
	String.prototype.format = function() {
		var args = arguments;
		return this.replace(/{(\d+)}/g, function(match, number) {
			return typeof args[number] != 'undefined' ? args[number] : match;
		});
	};
}

(function($) {
	var electricCard = null;
	var waterCard = null;

	$("#dashboardMenu,#sourceMenu,#eventMenu,#exportMenu,#boardRegistration")
			.click(function() {
				var idli = $(this).attr("id");
				window.sessionStorage.setItem('id', idli);
			});

	var dashboard_card_template = '<div class="card-box">'
			+ '<div class="card-box__container">'
			+ '<div class="accommodation_name">'
			+ '<h3 class="title">'
			+ '<img class="icon accomm-icon" src="resources/public/img/icons/svg/003-house.svg" alt=""> {0}'
			+ '</h3>' + '</div>' + '<div class="data_info">'
			+ '<div class="usage_item">' + '<span class="usage_title">'
			+ 'Electricity :' + '</span>' + '<span class="usage_total">'
			+ '{1} <i class="unit">kwh</i>' + '</span>' + '</div>'
			+ '<div class="usage_item">' + '<span class="usage_title">'
			+ 'Water : ' + '</span>' + '<span class="usage_total">'
			+ '{2} <i class="unit">m<sup>3</sup></i>' + '</span>' + '</div>'
			+ '</div>' + '</div>' + '</div>';

	var source_card_template = '<div class="card-box">'
			+ '<div class="card-box__container">'
			+ '<div class="accommodation_name">'
			+ '<h3 class="title">'
			+ '<img class="icon accomm-icon" src="resources/public/img/icons/svg/003-house.svg" alt="">'
			+ 'Room : {0}' + '</h3>' + '</div>' + '<div class="data_info">'
			+ '<div class="usage_item">' + '<span class="usage_title">'
			+ 'Electricity :' + '</span>' + '<span class="usage_total">'
			+ '{1} <i class="unit">kwh</i>' + '</span>' + '</div>'
			+ '<div class="usage_item">' + '<span class="usage_title">'
			+ 'Water : ' + '</span>' + '<span class="usage_total">'
			+ '{2} <i class="unit">m<sup>3</sup></i>' + '</span>' + '</div>'
			+ '</div>' + '</div>' + '</div>';

	var event_card_template = '<div class="card-box">'
			+ '<div class="card-box__container">'
			+ '<div class="action-box slideTop">'
			+ '<li class="action-item">'
			+ '<button name="saveCard"  class="action-btn edit-btn" style="display: none">Save</button>'
			+ '</li>'
			+ '<li class="action-item">'
			+ '<button name="cancelCard" class="action-btn edit-btn" style="display: none">Cancel</button>'
			+ '</li>'
			+ '<li class="action-item">'
			+ '<button class="action-btn edit-btn" name="edit">'
			+ '<img src="resources/public/img/icons/svg/051-edit.svg" class="action-icon"/>'
			+ '</button>'
			+ '</li>'
			+ '<li class="action-item">'
			+ '<button class=" modal hide action-btn delete-btn" data-backdrop="static" data-keyboard="false" id="del({4})" name=delete>'
			+ '<img src="resources/public/img/icons/svg/050-delete-button.svg" class="action-icon"/>'
			+ '</button>'
			+ '</li>'
			+ '</div>'
			+ '<div class="accommodation_name">'
			+ '<h3 class="title">'
			+ '<img class="icon accomm-icon" src="resources/public/img/icons/svg/003-house.svg" alt=""> {0}'
			+ '</h3>'
			+ '</div>'
			+ '<form class="data_info" id="validateEventCard">'
			+ '<div class="usage_item">'
			+ '<span class="usage_title">'
			+ 'Electricity Alert: '
			+ '</span>'
			+ '<span class="usage_total">'
			+ '<input class="Alert" type="number" min="0" readonly onkeydown="javascript: return event.keyCode == 69 ? false : true" name="editElectric" onkeypress="return event.charCode >= 48" value="'
			+ '{1}'
			+ '"> <i class="unit">kwh</i>'
			+ '</span>'
			+ '</div>'
			+ '<div class="usage_item" style="display:none;">'
			+ '<span class="usage_title">'
			+ 'ID Alert: '
			+ '</span>'
			+ '<span class="usage_total">'
			+ '<input class="Alert" type="number" min="0" readonly name="idd" onkeypress="return event.charCode >= 48"  value="'
			+ '{4}'
			+ '"> <i class="unit">kwh</i>'
			+ '</span>'
			+ '</div>'
			+ '<div class="usage_item">'
			+ '<span class="usage_title">'
			+ 'Water Alert: '
			+ '</span>'
			+ '<span class="usage_total">'
			+ '<input class="Alert" type="number" min="0" readonly onkeydown="javascript: return event.keyCode == 69 ? false : true" onkeypress="return event.charCode >= 48" name="editWater"   value="'
			+ '{2}'
			+ '"> <i class="unit">m<sup>3</sup></i>'
			+ '</span>'
			+ '</div>'
			+ '<div class="usage_item">'
			+ '<span class="usage_title">'
			+ 'Alert Email: '
			+ '</span>'
			+ '<span class="usage_total">'
			+ '<input class="emailAlert" type="email" readonly name="editEmail" value="'
			+ '{3}' + '"> </span>' + '</div>' + '</form>' + '</div>' + '</div>';

	var region_div_template = '<div class="card-box__outter uk-flex uk-flex-wrap uk-flex-wrap-around" id="{0}"></div>';

	$(window).on('load',function(e){
		loadDashBoard()
	})
	var loadDashBoard=function() {
				$('.loading-spinner').addClass('active');
				$.ajax({
					url : 'dash',
					type : 'GET',
					method : 'GET',
					success : function(response) {
						$('.loading-spinner').removeClass('active');
						var data = response.data;
						var rendered_card = ""
						for (var i = 0; i < data.length; i++) {
							rendered_card = rendered_card + dashboard_card_template.format(
									data[i].region_name, Math.round(data[i].power * 1000)/1000,
									Math.round(data[i].water * 1000)/1000);
							//$('#dashboardDiv').append(rendered_card);
							
							
						}
						document.getElementById('dashboardDiv').innerHTML=rendered_card;
						
					},
					error : function(error) {
						alert('Error loading dashboard data.');
						$('.loading-spinner').removeClass('active');
					}
				});
		
			};

	var loadSourceData = function() {
		if (true) {
			$('.loading-spinner').addClass('active');
			$
					.ajax({
						url : 'sourceload',
						type : 'GET',
						success : function(response) {
							
							$('.loading-spinner').removeClass('active');
							$('.accommodation_list').html('');
							$('#regionDiv').html('');
							var data = response.data;
							var uniqueRegion = {};
					
							

							for (var i = 0; i < data.length; i++) {
								var region_id = data[i].region_id, region_name = data[i].region_name, room = data[i].room_name, power = Math.round(data[i].power * 1000)/1000, water = Math.round(data[i].water * 1000)/1000;
								var regionDivID = "region" + region_id;
								
								var regionLink = '<li><a href="#">'
										+ region_name + '</a></li>';
								if (!uniqueRegion.hasOwnProperty(region_id)) {
									uniqueRegion[region_id] = region_name;
									var regionDiv = region_div_template
											.format(regionDivID);

									$('.accommodation_list').append(regionLink);
									$('#regionDiv').append(regionDiv);
								}
								var rendered_card = source_card_template
										.format(room, power, water);

								$('#' + regionDivID).append(rendered_card);
							}

						},
						error : function(error) {
							alert('Error loading source data.');
							$('.loading-spinner').removeClass('active');
						}
					});
		}
	}

	var getLocation = function() {
		if (true) {
			$('.loading-spinner').addClass('active');
			$.ajax({
				url : 'exportloc',
				type : 'POST',
				success : function(response) {
					data = response.data;
					var selected_val;
					$('.select_location').html('');
					var option_template = '<option value="{0}">{1}</option>';
					for (i = 0; i < data.length; i++) {
						$('.select_location').append(
								option_template
										.format(data[i].id, data[i].name));
						if (i == 0) {
							selected_val = data[i].id;
						}
					}

					$('.select_location').val(selected_val).change();

					$('.loading-spinner').removeClass('active');
				},
				error : function(error) {
					alert("error loading location");
					$('.loading-spinner').removeClass('active');
				}
			});
		}

	}

	var getEvents = function() {

		if (true) {
			$('.loading-spinner').addClass('active');

			$.ajax({
				url : 'getEvents',
				type : 'GET',
				success : function(response) {
					data = response.data;
					$('#eventListDiv').html("");
					for (var i = 0; i < data.length; i++) {
						$('#eventListDiv').append(
								event_card_template.format(data[i].roomName,
										data[i].over_usage_power,
										data[i].over_usage_water,
										data[i].email, data[i].roomID));
					}
					

					$('.loading-spinner').removeClass('active');
				},
				error : function(error) {
					$('.loading-spinner').removeClass('active');
				}
			});
		}
	}
	$('#dashboardMenu').on('click', function(e) {
		e.preventDefault();
		loadDashBoard();
	});
	
	$('#sourceMenu').on('click', function(e) {
		e.preventDefault();
		loadSourceData();
	});

	$('#eventMenu').on('click', function(e) {
		e.preventDefault();
		getEvents();
	});
	$('#exportMenu, #eventMenu').on('click', function(e) {
		e.preventDefault();
		getLocation();
	});

	$('#boardRegistration').on('click', function(e) {
		e.preventDefault();
		getLocation();
	});
	

	$('.select_location')
			.on(
					'change',
					function(e) {
						var location_id = $(this).val();
						$
								.ajax({
									url : 'exportreg',
									tranditional : true,
									type : 'GET',
									data : {
										"id" : location_id
									},
									success : function(response) {
										var data = response.data;
										var selected_val;
									
										$('.select_region').html('');
										$('.select_room').html('');
									/*	$('.select_name').html('');*/
										var option_template = '<option value="{0}">{1}</option>';
										for (i = 0; i < data.length; i++) {
											$('.select_region').append(
													option_template.format(
															data[i].id,
															data[i].name));
											if (i == 0) {
												selected_val = data[i].id;
											}
										}

										$('.select_region').val(selected_val)
												.change();
									}
								});
					});

	$('.select_region')
			.on(
					'change',
					function(e) {
						var region_id = $(this).val();
						$
								.ajax({
									url : 'exportroom',
									tranditional : true,
									type : 'GET',
									data : {
										"id" : region_id
									},
									success : function(response) {
										data = response.data;
										$('.select_room').html('');
									/*	$('.select_name').html('');*/
										var option_template = '<option value="{0}">{1}</option>';
										for (i = 0; i < data.length; i++) {
											$('.select_room').append(
													option_template.format(
															data[i].id,
															data[i].id));
											/*$('.select_name').append(
													option_template.format(
															data[i].name,
															data[i].name));*/
										}
									}
								});
					});
	$('.select_room')
	.on(
			'change',
			function(e) {
				var room_id = $(this).val();
				$
						.ajax({
							url : 'exportroomname',
							tranditional : true,
							type : 'GET',
							data : {
								"id" : room_id
							},
							success : function(response) {
								data = response.data;
						/*	$('.select_name').html('');*/
								var option_template = '<option value="{0}">{1}</option>';
								for (i = 0; i < data.length; i++) {
									$('.select_name').append(
											option_template.format(
													data[i].name,
													data[i].name));
									
									
								}
							}
						});
			});
	$('.select_name')
	.on(
			'change',
			function(e) {
				var room_name = $(this).val();
				
				$
						.ajax({
							url : 'exportroomid',
							tranditional : true,
							type : 'GET',
							data : {
								"id" : room_name
							},
							success : function(response) {
								data = response.data;
								var option_template = '<option value="{0}">{1}</option>';
								$('.select_room').html('');
								for (i = 0; i < data.length; i++) {
									$('.select_room').append(
											option_template.format(
													data[i].id,
													data[i].id));
									
									
								}

								

							}
						});
			});
				
	$('#export_form').on(
			'submit',
			function(e) {
				e.preventDefault();
				var room_id = $('#export_room').val();
				var export_from = $('#export_from').val();
				var export_until = $('#export_until').val();
				var error_from = undefined;
				var error_until = undefined;
				var error_both = undefined;

				var row_template = '<tr>' + '<td>{0}</td>' + '<td>{1}</td>'
						+ '<td>{2} <span>kwh</span></td>'
						+ '<td>{3} <span>m<sup>3</sup></span></td>' + '</tr>';
				if (export_from === "") {
					error_from = "From Date is required!";
				}

				if (export_until === "") {
					error_until = "Until Date is required!";
				}
				if (export_from === "" && export_until === "") {
					error_both = "Please Select the Date!";
				}

				if (export_from === "") {
					swal(error_from, '', 'error');
				}
				if (export_until === "") {
					swal(error_until, '', 'error');
				}
				if (export_from === "" && export_until === "") {
					swal(error_both, '', 'error');
				}
				if ((error_from === undefined) && (error_until === undefined)) {
					$.ajax({

						url : 'exportoutput',
						tranditional : true,
						type : 'POST',
						data : {
							"id" : room_id,
							"export_from" : export_from,
							"export_until" : export_until
						},

						success : function(response) {
							var data = response.data;
							$('#export_table').html('');
							$('#export_table').append(
									row_template.format(data.id, data.name,
											data.power, data.water));
							$("#roomExportBtn").removeClass("uk-hidden");
						},
						error : function(error) {
							alert("error creating export");
							$("#roomExportBtn").addClass("uk-hidden");
							$('.loading-spinner').removeClass('active');
						}
					});
					return "success";
				}

			});

	$('.source #sidebarTrigger').on('click', function(e) {
		e.preventDefault();
		$('.source .sidebar').toggleClass('active');
	});

	$('.event #sidebarTrigger').on('click', function(e) {
		e.preventDefault();
		$('.event .sidebar').toggleClass('active');
	});

	$('#roomExportBtn').on('click', function(e) {
		e.preventDefault();
		$('#room_export_table').tableExport({
			type : 'pdf',
			jspdf : {
				orientation : 'l',
				format : 'a3',
				margins : {
					left : 10,
					right : 10,
					top : 20,
					bottom : 20
				},
				autotable : {
					styles : {
						fillColor : 'inherit',
						textColor : 'inherit'
					},
					tableWidth : 'auto'
				}
			}
		});

	});
	

	$("#boardsubmit")
			.validate(
					{
						rules : {
							electric_gt : "required",
							water_gt : "required",
							email_adress : {
								required : true,
								email : true,

							}

						},
						messages : {
							electric_gt : "Please fill out the power usage",
							water_gt : "Please fill out the water usage",
							email_adress : {
								required : "Please fill out email address",
								email : "Please enter a valid email address",
							}
						},
						submitHandler : function(form) {
							var water = $("#waterr").val();
							var power = $("#electricc").val();
							var room = $("#event_room").val();
							var messages = $("#messagese").val();
							var email = $("#emaill").val();
							var data = {
								'water' : water,
								'power' : power,
								'roomID' : room,
								'messages' : messages,
								'email' : email
							};
							$('.loading-spinner').addClass('active');
							$
									.ajax({
										url : 'jobEvent',
										type : 'POST',
										dataType : "json",
										contentType : "application/json; charset=utf-8",
										data : JSON.stringify(data),
										success : function(response) {

											if (response.status === '200') {
												$('#waterr').val("");
												$('#electricc').val("");
												$('#emaill').val("");
												$('#messagese').val("");

												var roomName = response.room[0].name;
												var roomID = response.room[0].roomID;

												swal(
														{
															title : "Successfully Created",
															icon : "success"
														})
														.then(
																function() {

																	var renderCard = event_card_template
																			.format(
																					roomName,
																					power,
																					water,
																					email,
																					roomID);
																	$(
																			'#eventListDiv')
																			.append(
																					renderCard);
																})
											} else {
												swal(response.message, '',
														'error');
											}
											$('.loading-spinner').removeClass(
													'active');
											UIkit.modal('#event_form_modal')
													.hide();
										},
										error : function(error) {

											$('.loading-spinner').removeClass(
													'active');
										}

									});

						}
					});

	$("#boardlocation").validate({
		rules : {
			boardlocid : "required",
			boardlocname : "required"
		},
		messages : {
			boardlocid : "Please fill out Location ID",
			boardlocname : "Please fill out Location Name"
		},
		submitHandler : function(form) {
			var locationID = $('#board_locationid3').val();
			var locationName = $('#board_locationname3').val();
			$.ajax({
				url : 'boardlocation',
				tranditional : true,
				type : 'POST',
				data : {
					'locationID' : locationID,
					'locationName' : locationName

				},
				success : function(response) {
					if (response.status === '200') {
						swal({
							title : "Successfully Registration",
							icon : "success"
						}).then(function() {
							//window.location.reload(true);
							getLocation();
						});
					} else {
						swal(response.message, '', 'error');
					}
					var data = response.data;
					var locationID = $('#board_locationid3').val("");
					var locationName = $('#board_locationname3').val("");

				},
				error : function(error) {
					swal('Error', ' ', 'error')
					alert("error creating event")
					$('.loading-spinner').removeClass('active');
				}
			});
		}

		
	});
	$("#boardregion").validate({
		rules : {
			boardregionid : "required",
			boardregionname : "required"
		},
		messages : {
			boardregionid : "Please fill out Region ID",
			boardregionname : "Please fill out Region Name"
		},
		submitHandler : function(form) {
			var regionID = $('#board_regionid2').val();
			var regionName = $('#board_regionname2').val();
			var locationID = $('#board_location2').val();
			$.ajax({
				url : 'boardregion',
				tranditional : true,
				type : 'POST',
				data : {
					"regionID" : regionID,
					"regionName" : regionName,
					"locationID" : locationID
				},
				success : function(response) {
					if (response.status === '200') {
						swal('Successfully Registration', '', 'success').then(function() {
							//window.location.reload(true);
							getLocation();
						});
					} else {
						swal(response.message, '', 'error');
					}
					var data = response.data;
					var regionID = $('#board_regionid2').val("");
					var regionName = $('#board_regionname2').val("");

				},
				error : function(error) {
					swal('Error', ' ', 'error');
					$('.loading-spinner').removeClass('active');
				}
			});
			}
		
	});

	$("#boardroom").validate({
		rules : {
			roomid : "required",
			roomname : "required"
		},
		messages : {
			roomid : "Please fill out Room ID",
			roomname : "Please fill out Room Name"
		},
		submitHandler : function(form) {
			var regionID = $('#board_region1').val();
			var roomID = $('#board_roomid1').val();
			var roomName = $('#board_roomname1').val();
			$.ajax({
				url : 'boardroom',
				tranditional : true,
				type : 'POST',
				data : {
					"regionID" : regionID,
					"roomID" : roomID,
					"roomName" : roomName
				},
				success : function(response) {
					if (response.status === '200') {
						swal('Successfully Registration', '', 'success').then(function() {
							getLocation();
						});
					} else {
						swal(response.message, '', 'error');
					}
					var data = response.data;
					var roomID = $('#board_roomid1').val("");
					var roomName = $('#board_roomname1').val("");

				},
				error : function(error) {
					swal('Error', ' ', 'error');
					$('.loading-spinner').removeClass('active');
				}
			});
			}
		
	})

	$("#boardboard").validate({
		rules : {
			boardmac : {
				required : true,
				minlength : 17
			}
		},
		messages : {
			boardmac:{
			required : "Please fill out your MAC Address",
			minlength : "Your Mac Address is invalid"
				}
		},
		submitHandler : function(form) {
			var id = $('#board_room').val();
			var MAC = $('#board_mac').val();
			
			$.ajax({
				url : 'boardboard',
				tranditional : true,
				type : 'POST',
				data : {
					"roomID" : id,
					"mac" : MAC
				},
				success : function(response) {
					if (response.status === '200') {
						swal(response.message, '', 'success');
					}
					if (response.status === '5') {
						swal(response.message, '', 'success');
					}
					var data = response.data;
					$('#board_mac').val("");

				},
				error : function(error) {
					swal('Cannot Updated', '', 'error');
					$('.loading-spinner').removeClass('active');
				}
			});
			
		}
	})

})(jQuery);

$(document).ready(function() {

	var idclick = window.sessionStorage.getItem("id");
	$("#" + idclick).trigger("click");

});

$(document).on(
		'click',
		'button[name=edit]',
		function() {

			$(this).parent().siblings().find('button[name=saveCard]').css(
					'display', 'block');
			$(this).parent().siblings().find('button[name=cancelCard]').css(
					'display', 'block');
			var root_div = $(this).parent().parent();
			var div_input = root_div.siblings(".data_info");

			defaultElectric = div_input.children().find(
					'input[name=editElectric]').val();
			defaultWater = div_input.children().find('input[name=editWater]')
					.val();
			defaultEmail = div_input.children().find('input[name=editEmail]')
					.val();

			div_input.find('[readonly]').each(function() {
				$(this).removeAttr("readonly");
			});

		});

$(document).on(
		'click',
		'button[name=cancelCard]',
		function() {

			var cancelBtn = $(this);
			$(this).parent().siblings().find('button[name=saveCard]').css(
					'display', 'none');
			$(this).parent().siblings().find('button[name=cancelCard]').css(
					'display', 'none');
			var root_div = $(this).parent().parent();
			var div_input = root_div.siblings(".data_info");

			div_input.children().find('input[name=editElectric]').val(
					defaultElectric);
			div_input.children().find('input[name=editWater]')
					.val(defaultWater);
			div_input.children().find('input[name=editEmail]')
					.val(defaultEmail);

			div_input.find('input').each(function() {
				$(this).attr("readonly", true);
			});
			cancelBtn.css('display', 'none');

		});
$(document)
		.on(
				'click',
				'button[name=saveCard]',
				function() {
					var saveBtn = $(this);
					$(this).parent().siblings().find('button[name=saveCard]')
							.css('display', 'none');
					$(this).parent().siblings().find('button[name=cancelCard]')
							.css('display', 'none');
					var root_div = $(this).parent().parent();
					var div_input = root_div.siblings(".data_info");
					div_input.find('input').each(function() {
						$(this).attr("readonly", true);
					});

					var updateElectric = div_input.children().find(
							'input[name=editElectric]').val();
					var updateWater = div_input.children().find(
							'input[name=editWater]').val();
					var updateEmail = div_input.children().find(
							'input[name=editEmail]').val();
					var roomID = div_input.children().find('input[name=idd]')
							.val();
					var data = {

						'updateElectric' : updateElectric,
						'updateWater' : updateWater,
						'updateEmail' : updateEmail,
						'roomID' : roomID

					};
					var re = /^[a-zA-Z][\w\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\w\.-]*[a-zA-Z0-9]\.[a-zA-Z][a-zA-Z\.]*[a-zA-Z]$/;
					var result = re.test(updateEmail.toLowerCase());
					if (updateElectric === "") {
						div_input.find('input[name=editElectric]').each(
								function() {
									$(this).css('border', ' red solid 1px');

								});
					} else {
						saveBtn.css('display', 'none');
					}
					if (updateWater === "") {
						div_input.find('input[name=editWater]').each(
								function() {
									$(this).css('border', ' red solid 1px');

								});
					} else {
						saveBtn.css('display', 'none');
					}
					if (result === false) {
						div_input.find('input[name=editEmail]').each(
								function() {
									$(this).css('border', ' red solid 1px');

								});
					} else {

						saveBtn.css('display', 'none');
					}
					if ((updateElectric != "") && (updateWater != "")
							&& (result === true)) {

						$('.loading-spinner').addClass('active');
						$.ajax({
							url : 'updateCard',
							type : 'POST',
							dataType : "json",
							contentType : "application/json; charset=utf-8",
							data : JSON.stringify(data),

							success : function(response) {

								if (response.status === '200') {
									saveBtn.css('display', 'none');
									swal('Successfully Saved', '', 'success');
									div_input.find('input').each(function() {
										$(this).css('border', 'none');

									});
								}

								$('.loading-spinner').removeClass('active');

							},
							error : function(error) {

								swal('Cannot Saved', '', 'error');
								$('.loading-spinner').removeClass('active');
							}

						});
					}

				});

$(document)
		.on(
				'click',
				'button[name=delete]',
				function() {
					var root_div = $(this).parent().parent();
					var current = $(this);
					var div_input = root_div.siblings(".data_info");
					var roomID = div_input.children().find('input[name=idd]')
							.val();

					swal({

						title : "Are you sure?",
						closeOnClickOutside: false,
						icon : "warning",
						buttons : [ 'No, cancel it!', 'Yes, I am sure!' ],
						dangerMode : true,

					})
							.then(
									function(isConfirm) {
										if (isConfirm) {
											swal(
													{
														title : 'Deleted!',
														text : 'This card is successfully deleted!',
														icon : 'success'
													})
													.then(
															function() {

																$(
																		'.loading-spinner')
																		.addClass(
																				'active');
																data = {
																	'roomID' : roomID
																};
																$
																		.ajax({
																			url : 'deleteCard',
																			type : 'POST',
																			dataType : "json",
																			contentType : "application/json; charset=utf-8",
																			data : JSON
																					.stringify(data),

																			success : function(
																					response) {
																				if (response.status === '200') {
																					$(
																							'.loading-spinner')
																							.removeClass(
																									'active');
																					current
																							.parent()
																							.parent()
																							.parent()
																							.parent()
																							.remove();
																				}

																			},
																			error : function(
																					error) {

																				$(
																						'.loading-spinner')
																						.removeClass(
																								'active');
																			}
																		});
															});
										} 
									});
				});

$(function() {
	var dateFormat1 = "yy-mm-dd", from = $("#export_from").datepicker({
		closeText : "Close",
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 1,
		maxDate : "Now",
		dateFormat : "yy-mm-dd"
	}).on("change", function() {
		to.datepicker("option", "minDate", getDate(this));
	}), to = $("#export_until").datepicker({
		closeText : "Close",
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 1,
		maxDate : "Now",
		dateFormat : "yy-mm-dd"
	}).on("change", function() {
		/*
		 * var date = Date.parse($(this).val()); if (date > Date.now()){
		 * 
		 * $(this).val(''); }
		 */
		from.datepicker("option", "maxDate", getDate(this));
	});

	function getDate(element) {
		var date;

		try {

			date = $.datepicker.parseDate(dateFormat1, element.value);

		} catch (error) {
			date = null;
		}

		return date;
	}
});
$('input[name=boardlocname]').on('keypress', function (event) {
    var regex = new RegExp("^[a-zA-Z 0-9]+$");
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    if (!regex.test(key)) {
       event.preventDefault();
       return false;
    }
});
$('input[name=boardregionname]').on('keypress', function (event) {
    var regex = new RegExp("^[a-zA-Z 0-9]+$");
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    if (!regex.test(key)) {
       event.preventDefault();
       return false;
    }
});
$('input[name=roomname]').on('keypress', function (event) {
    var regex = new RegExp("^[a-zA-Z 0-9]+$");
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    if (!regex.test(key)) {
       event.preventDefault();
       return false;
    }
});
$('input[name=boardmac]').on('keypress', function (event) {
    var regex = new RegExp("^[a-zA-Z0-9]+$");
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    if (!regex.test(key)) {
       event.preventDefault();
       return false;
    }
});
$('#board_mac').keyup(function() {
    var foo = $(this).val().replace(/-/g, ""); // remove hyphens
    // You may want to remove all non-digits here
    // var foo = $(this).val().replace(/\D/g, "");

    if (foo.length > 0) {
        foo = format(foo, [2, 2, 2, 2, 2], "-");
    }
  
    $(this).val(foo);
});

function format(input, format, sep) {
    var output = "";
    var idx = 0;
    for (var i = 0; i < format.length && idx < input.length; i++) {
        output += input.substr(idx, format[i]);
        if (idx + format[i] < input.length) output += sep;
        idx += format[i];
    }

    output += input.substr(idx);

    return output;
}

/*
$('#board_mac').keyup(function(){
    $(this).val($(this).val().replace(/(\d{3})\-?(\d{3})\-?(\d{4})/,'$1-$2-$3'))
});*/