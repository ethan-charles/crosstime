<template>
	<view>
		<!-- 标题栏 -->
		<view class="header" :style="{'height':titleBarHeight,'padding-top':statusBarHeight,'background-color': '#F8F8F8'}">
			<image class='header-back' src='/static/logo.png' @click="gotoConn()"></image>
			<view class="header-front">
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
				/>
			</view>
			
		</view>	
		<view :style="{'height':titleBarHeight,'padding-top':statusBarHeight}"></view>
		
		<!-- 搜索框 vip-->
		<view class="function">
			<!-- <input v-model="value" focus placeholder="在此输入文字" class="input"> -->
			<input focus placeholder="在此输入文字" class="input"> 
			<view class="tag">
				<image src='../../static/profession.png' @click="goprofession()" style="height: 80upx; width: 100upx;"></image>
				<view style="font-size: small;">专业模块</view>
			</view>
		</view>
		
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
				<image src='../../static/03.png' style="height: 80upx; width: 140upx;"></image>
				<view style="font-size: small;">收藏</view>
			</view>
			<view class="tag" @click="goTag(3)">
				<image src='../../static/04.png' style="height: 105upx; width: 150upx;"></image>
				<view style="font-size: small;">广场</view>
			</view>
			<view class="tag" @click="goTag(4)">
				<image src='../../static/05.gif' style="height: 105upx; width: 150upx;"></image>
				<view style="font-size: small;">排行榜</view>
			</view>
		</view>
		<view style="height: 40rpx;"></view>
		<view>
			<image src="../../static/study-page.png" style="width:750rpx; height: 800rpx;"></image>
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
				titleBarHeight: 0,
				statusBarHeight: 0,
				
				listBoxStyle: `height: 40px; font-size: 16px;`,
				list: [
					'中',
					'英',
					'韩',
					'日', 
					'西',
				],
				userInfo: {},
				hasUserInfo: false,
				canIUseGetUserProfile: false,
				code:'',
				openid: '',
				session_key: '',
				encryptedData: ',',
				iv: '',
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
					url: "../mine-study/mine-study"
				});
			},
			goprofession(){
				uni.navigateTo({
					url: "../profession/profession"
				});
			},
			gopage(e){
				if (e){
					uni.navigateTo({
						url: "../study/study"
					});
				}else{
					uni.navigateTo({
						url: "../teach/teach"
					});
				}
			}
			
		}
	}
</script>

<style lang="scss">
	@import '@/common/uni-nvue.scss';

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
	.header-back {
		position: absolute;
		left:15upx;
		font-size:30upx;
		padding: 10upx;
		height: 50upx;
		width: 50upx;
		// border-radius: 25upx;
	}
	.header-front {
		// position: absolute;
		// right: 250upx;
		// font-size:30upx;
		// padding: 10upx;
		// width: 150upx;
		// height: 10upx;
		// display: flex;
		width: 80%; margin: auto; margin-bottom: 20px; display: flex; flex-direction: row; justify-content: center;
	}
	
	.classification {
		display: flex;
		align-items: stretch;
		align-content: stretch;
		justify-content: space-around;
		flex-wrap: wrap;
	}
	.function {
		display: flex;
		align-items: stretch;
		align-content: stretch;
		justify-content: space-around;
		flex-wrap: wrap;
	}
	.input {
		width: 75%;
		margin: auto;
		height: 40px;
		border-width:1px;
		border-style:solid;
		border-color:#000000;
		border-radius: 5px;
	}
	.tag {
		display: flex;
		flex-direction: column;
		align-items: center;
		width: 20%;
		margin-top: auto;
	}
</style>
