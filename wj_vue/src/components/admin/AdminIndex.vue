<template>
    <div>
        <el-row style="z-index: 1">
          <Header style="width: 100%;position: absolute;"></Header>
        </el-row>
        <el-row style="z-index: 0">
            <el-col style="width: 250px;">
                <admin-menu></admin-menu>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import Header from './Header'
import AdminMenu from './AdminMenu'

export default {
    name: 'Admin',
    components: {
        Header, AdminMenu
    }
}
</script>