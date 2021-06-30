<template>
	<view class="container">
		<view class="header" :style="{'height':titleBarHeight,'padding-top':statusBarHeight,'background-color': '#F8F8F8'}">
			<image class='header-back' src='/static/logo.png' style="height: 50upx; width: 50upx;" @click="gotoConn()"></image>
			<view style="width: 80%; margin: auto;margin-bottom: 20px; display: flex; flex-direction: row; justify-content: center;">
				<xfl-select 
				:list="list"
				:clearable="false"
				:showItemNum="5" 
				:listShow="false"
				:isCanInput="false"  
				:style_Container="listBoxStyle"
				:placeholder = "'placeholder'"
				:initValue="'中'"
				:selectHideType="'independent'"
				style="width: 200rpx;"
				>
				</xfl-select>
			</view>
		</view>
		<view :style="{'height':titleBarHeight,'padding-top':statusBarHeight}"></view>
		<view class="classification">
			<view class="tag" @click="goTag(0)">
				<image src='../../static/01.gif' style="height: 105upx; width: 150upx;"></image>
				<view style="font-size: small;">消息</view>
			</view>
			<view class="tag" @click="goTag(1)">
				<image src='../../static/02.gif' style="height: 105upx; width: 150upx;"></image>
				<view style="font-size: small;">历史</view>
			</view>
			<view class="tag" @click="goTag(2)">
				<image src='../../static/04.png' style="height: 105upx; width: 150upx;"></image>
				<view style="font-size: small;">广场</view>
			</view>
			<view class="tag" @click="goTag(3)">
				<image src='../../static/05.gif' style="height: 105upx; width: 150upx;"></image>
				<view style="font-size: small;">排行榜</view>
			</view>
		</view>
		<view style="position:relative; top: 200rpx;">
			<image class="wind" src="../../static/clock2.png" style="height: 300rpx;"></image>
			<text class="wind">请选择本次教学接受的聊天方式</text>
			<uni-group >
				<uni-data-checkbox class="checkbox" mode="button" multiple v-model="formData.hobby" :localdata="hobby"></uni-data-checkbox>
			</uni-group>
			<text class="wind" style="height: 80rpx;">空闲至:_____ : _____a.m.</text>
			<image class="wind" src="../../static/confirm.png" style="height: 60rpx; width: 40%;"></image>
		</view>
		<view class='btns'>
			<image src="../../static/images/study.gif" @click="gopage(1)"style="width:370rpx; height: 200rpx;"></image>
			<image src="../../static/images/teach.png" @click="gopage(0)"style="width:370rpx; height: 200rpx;"></image>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				listBoxStyle: `height: 20px; font-size: 16px;`,
				list: [
					'英',
					'韩',
					{value: '日', disabled: true},
					'德',
					'西',
				],
				statusBarHeight: 0,
				titleBarHeight: 0,
				formData: {
						value: 1,
						hobby: [1]
					},
					hobby: [{
						text: '电话',
						value: 0
					}, {
						text: '视频',
						value: 1
					}],
					
			}
		},
		created() {
			var that = this;
			uni.getSystemInfo({
				success: function(res) {
					if (res.model.indexOf('iPhone') !== -1) {
						that.titleBarHeight = '44px';
					} else {
						that.titleBarHeight = '48px';
					}
					that.statusBarHeight = res.statusBarHeight + 'px'
				}	
			})
			
		},
		methods: {
			gotoConn(){
				uni.navigateTo({
					url: "../mine-teach/mine-teach"
				});
			},
			gopage(e){
				if (e){
					uni.navigateTo({
						url: "../study/study"
					});
				}else{
					uni.navigateTo({
						url: "../teach/teach" //可以省略
					});
				}
			}
			
		}
	}
</script>

<style lang="scss">
	@import '@/common/uni-nvue.scss';
	.checkbox{
		position: relative;
		
		width: 80%; 
		margin: auto; 
		display: flex; 
		flex-direction: row; 
		justify-content: center;
	}
	.wind{
		width: 80%; 
		margin: auto;
		margin-bottom: auto;
		display: flex;
		flex-direction: row; 
		justify-content: center;
		font-size: 18px;
	}
	.example {
		padding: 10px;
		background-color: #fff;
	}
	
	.text {
		font-size: 14px;
		color: #333;
		margin-bottom: 10px;
	}
	.container {
		position: relative;
	}
	.btns {
		display: flex;
		align-items: center;
		position: fixed;
		flex-direction: row;
		bottom: 0;
		z-index: 100;
		left:0;
		align-self: center;
	}
	.header {
		display: flex;
		align-items: center;
		top: 0;
		position: fixed;
		width: 100%;
		z-index: 100;
		left:0;
	}
	.header-title {
		position: absolute;
		left: 50%;
		font-size: 38upx;
		transform: translateX(-50%);
	}
	.header-back {
		position: absolute;
		left:15upx;
		font-size:30upx;
		padding: 10upx;
		/* border-radius: 50%; */
	}
	.classification {
		display: flex;
		align-items: stretch;
		align-content: stretch;
		justify-content: space-around;
		flex-wrap: wrap;
	}
	.tag {
		display: flex;
		flex-direction: column;
		align-items: center;
		width: 25%;
		margin-top: auto;
	}

</style>
